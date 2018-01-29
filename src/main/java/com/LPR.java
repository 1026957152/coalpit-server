 package com;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.win32.StdCallLibrary;

public interface LPR extends StdCallLibrary {


    String path= LPR.class.getResource("").getPath().replaceFirst("/","").replaceAll("%20"," ");


    LPR INSTANCE = (LPR) Native.loadLibrary(".\\VzLPRSDK", LPR.class);

    //LPR INSTANCE = (LPR) Native.loadLibrary(path + "bin/VzLPRSDK", LPR.class);

    /**图像信息*/
    public static class VZ_LPRC_IMAGE_INFO_Pointer extends Structure
    {
        public int uWidth;			/**<宽度*/
    public int uHeight;		/**<高度*/
    public int uPitch;			/**<图像宽度的一行像素所占内存字节数*/
    public int uPixFmt;		/**<图像像素格式，参考枚举定义图像格式（ImageFormatXXX）*/
    public ByteByReference pBuffer;	/**<图像内存的首地址*/

    public static class ByReference extends VZ_LPRC_IMAGE_INFO_Pointer implements Structure.ByReference {}
        public static class ByValue extends VZ_LPRC_IMAGE_INFO_Pointer implements Structure.ByValue {}

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"uWidth", "uHeight", "uPitch", "uPixFmt","pBuffer"});
        }
    }

    public static class VZ_TM extends Structure
    {
        public short nYear;	/**<年*/
    public short nMonth;	/**<月*/
    public short nMDay;	/**<日*/
    public short nHour;	/**<时*/
    public short nMin;		/**<分*/
    public short nSec;		/**<秒*/

    public static class ByReference extends VZ_TM implements Structure.ByReference {}
        public static class ByValue extends VZ_TM implements Structure.ByValue {}

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"nYear", "nMonth", "nMDay", "nHour", "nMin", "nSec"});
        }
    }
	
	/*
	public static class VZ_TM_PERIOD_OR_RANGE extends Structure
	{
		public int			uEnable;
		public int			uIsSeg;
		public VZ_TM_WEEK_SEGMENT  struWeekSeg[8];
		public VZ_TM_RANGE			struRange;
	}
	*/


    /**黑白名单中的车辆记录*/
    public static class VZ_LPR_WLIST_VEHICLE extends Structure
    {
        public int	uVehicleID;
        public byte[] strPlateID = new byte[32];			/**<车牌字符串*/
    public int	uCustomerID;							/**<客户在数据库的ID，与VZ_LPR_WLIST_CUSTOMER::uCustomerID对应*/
    public int	bEnable;								/**<该记录有效标记*/
    public VZ_TM.ByReference		pStruTMOverdule;	/**<该记录过期时间,为空表示没有过期时间*/
    public int	bUsingTimeSeg;							/**<是否使用时间段*/
    public byte[]	byTimeSegOrRange = new byte[256];   /**struTimeSegOrRange;			<时间段信息*/
    public int	bAlarm;									/**<是否触发报警（黑名单记录）*/
    public int	iColor;									/**<车辆颜色*/
    public int	iPlateType;								/**<车牌类型*/
    public byte[]	strCode = new byte[32];				/**<车辆编码*/
    public byte[]	strComment = new byte[64];			/**<车辆编码*/

    public static class ByReference extends VZ_LPR_WLIST_VEHICLE implements Structure.ByReference {}
        public static class ByValue extends VZ_LPR_WLIST_VEHICLE implements Structure.ByValue {}
    }

    public static class VZ_LPR_WLIST_ROW extends Structure
    {
        public Pointer pCustomer;			/**<客户*/
    public VZ_LPR_WLIST_VEHICLE.ByReference pVehicle;				/**<车辆，可以为空*/

    public static class ByReference extends VZ_LPR_WLIST_ROW implements Structure.ByReference {}
        public static class ByValue extends VZ_LPR_WLIST_ROW implements Structure.ByValue {}
    }

    /**批量导入每行的结果*/
    public static class VZ_LPR_WLIST_IMPORT_RESULT extends Structure
    {
        public int ret;
        public int error_code;

        public static class ByReference extends VZ_LPR_WLIST_IMPORT_RESULT implements Structure.ByReference {}
        public static class ByValue extends VZ_LPR_WLIST_IMPORT_RESULT implements Structure.ByValue {}
    }

    /**识别结果的类型*/
    public enum VZ_LPRC_RESULT_TYPE
    {
        VZ_LPRC_RESULT_REALTIME,		/**<实时识别结果*/
    VZ_LPRC_RESULT_STABLE,			/**<稳定识别结果*/
    VZ_LPRC_RESULT_FORCE_TRIGGER,	/**<调用“VzLPRClient_ForceTrigger”触发的识别结果*/
    VZ_LPRC_RESULT_IO_TRIGGER,		/**<外部IO信号触发的识别结果*/
    VZ_LPRC_RESULT_VLOOP_TRIGGER,	/**<虚拟线圈触发的识别结果*/
    VZ_LPRC_RESULT_MULTI_TRIGGER,	/**<由_FORCE_\_IO_\_VLOOP_中的一种或多种同时触发，具体需要根据每个识别结果的TH_PlateResult::uBitsTrigType来判断*/
    VZ_LPRC_RESULT_TYPE_NUM			/**<结果种类个数*/
    }

    /**
     *  @brief 全局初始化
     *  @return 0表示成功，-1表示失败
     *  @note 在所有接口调用之前调用
     *  @ingroup group_global
     */
    int VzLPRClient_Setup();

    /**
     *  @brief 打开一个设备
     *  @param  [IN] pStrIP 设备的IP地址
     *  @param  [IN] wPort 设备的端口号
     *  @param  [IN] pStrUserName 访问设备所需用户名
     *  @param  [IN] pStrPassword 访问设备所需密码
     *  @return 返回设备的操作句柄，当打开失败时，返回0
     *  @ingroup group_device
     */
    int VzLPRClient_Open(String pStrIP, int wPort, String pStrUserName, String pStrPassword);

    /**
     *  @brief 向白名单表导入客户和车辆记录
     *  @param  [IN] handle 由VzLPRClient_Open函数获得的句柄
     *  @param  [IN] rowcount 记录的条数
     *  @param  [IN] pRowDatas 记录的内容数组的地址
     *  @param  [OUT] results 每条数据是否导入成功
     *  @return 0表示成功，-1表示失败
     *  @ingroup group_database
     */
    int VzLPRClient_WhiteListImportRows(int handle, int rowcount, VZ_LPR_WLIST_ROW.ByReference pRowDatas, VZ_LPR_WLIST_IMPORT_RESULT.ByReference pResults);

    /**
     *  @brief 设置识别结果的回调函数
     *  @param  [IN] handle 由VzLPRClient_Open函数获得的句柄
     *  @param  [IN] func 识别结果回调函数，如果为NULL，则表示关闭该回调函数的功能
     *  @param  [IN] pUserData 回调函数中的上下文
     *  @param  [IN] bEnableImage 指定识别结果的回调是否需要包含截图信息：1为需要，0为不需要
     *  @return 0表示成功，-1表示失败
     *  @ingroup group_device
     */
    int VzLPRClient_SetPlateInfoCallBack(int handle, VZLPRC_PLATE_INFO_CALLBACK func, Pointer pUserData, int bEnableImage);

    /**
     *  @brief 将图像保存为JPEG到指定路径
     *  @param  [IN] pImgInfo 图像结构体，目前只支持默认的格式，即ImageFormatRGB
     *  @param  [IN] pFullPathName 设带绝对路径和JPG后缀名的文件名字符串
     *  @param  [IN] nQuality JPEG压缩的质量，取值范围1~100；
     *  @return 0表示成功，-1表示失败
     *  @note   给定的文件名中的路径需要存在
     *  @ingroup group_global
     */
    int VzLPRClient_ImageSaveToJpeg(VZ_LPRC_IMAGE_INFO_Pointer.ByReference pImgInfo, String pFullPathName, int nQuality);

    /** 车牌坐标 */
    public static class TH_RECT_Pointer extends Structure {
        public int left;
        public int top;
        public int right;
        public int bottom;

        public static class ByReference extends TH_RECT_Pointer implements Structure.ByReference {}
        public static class ByValue extends TH_RECT_Pointer implements Structure.ByValue {}

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"left", "top", "right", "bottom"});
        }
    }

    public static class VZ_TIMEVAL_Pointer extends Structure
    {
        public int uTVSec;
        public int uTVUSec;

        public static class ByReference extends VZ_TIMEVAL_Pointer implements Structure.ByReference {}
        public static class ByValue extends VZ_TIMEVAL_Pointer implements Structure.ByValue {}

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"uTVSec", "uTVUSec"});
        }
    }

    /**分解时间*/
    public static class VzBDTime_Pointer extends Structure
    {
        public byte bdt_sec;    /**<秒，取值范围[0,59]*/
    public byte bdt_min;    /**<分，取值范围[0,59]*/
    public byte bdt_hour;   /**<时，取值范围[0,23]*/
    public byte bdt_mday;   /**<一个月中的日期，取值范围[1,31]*/
    public byte bdt_mon;    /**<月份，取值范围[1,12]*/
    public byte[] res1 = new byte[3];    /**<预留*/
    public int bdt_year;   /**<年份*/
    public byte[] res2 = new byte[4];    /**<预留*/

    public static class ByReference extends VzBDTime_Pointer implements Structure.ByReference {}
        public static class ByValue extends VzBDTime_Pointer implements Structure.ByValue {}

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"bdt_sec", "bdt_min","bdt_hour","bdt_mday","bdt_mon","res1","bdt_year","res2"});
        }
    }
    //broken-down time

    /** 识别结果结构体 */
    public static class TH_PlateResult_Pointer extends Structure {
        public byte[] license = new byte[16]; // 车牌号码
        public byte[] color = new byte[8]; // 车牌颜色
        public int nColor; // 车牌颜色序
        public int nType; // 车牌类型
        public int nConfidence; // 车牌可信度
        public int nBright; // 亮度评价
        public int nDirection; // 运动方向，0 unknown, 1 left, 2 right, 3 up , 4 down
        public TH_RECT_Pointer.ByValue rcLocation; // 车牌位置  error
        public int nTime; // 识别所用时间
        public VZ_TIMEVAL_Pointer.ByValue tvPTS;
        public int uBitsTrigType;
        public byte nCarBright; // 车的亮度
        public byte nCarColor; // 车的颜色
        public byte[] reserved0 = new byte[2];
        public int uId;
        public VzBDTime_Pointer.ByValue struBDTime;
        public byte[] reserved = new byte[68]; // 保留字

        public static class ByReference extends TH_PlateResult_Pointer implements Structure.ByReference {}
        public static class ByValue extends TH_PlateResult_Pointer implements Structure.ByValue {}

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"license", "color", "nColor", "nType", "nConfidence", "nBright", "nDirection", "rcLocation", "nTime", "nCarBright", "nCarColor", "reserved"});
        }
    }


    /**
     *  @brief 通过该回调函数获得车牌识别信息
     *  @param  [IN] handle			由VzLPRClient_Open函数获得的句柄
     *  @param  [IN] pUserData		回调函数的上下文
     *  @param  [IN] pResult			车牌信息数组首地址，详见结构体定义 TH_PlateResult
     *  @param  [IN] uNumPlates		车牌数组中的车牌个数
     *  @param  [IN] eResultType		车牌识别结果类型，详见枚举类型定义VZ_LPRC_RESULT_TYPE
     *  @param  [IN] pImgFull		当前帧的图像内容，详见结构体定义VZ_LPRC_IMAGE_INFO
     *  @param  [IN] pImgPlateClip	当前帧中车牌区域的图像内容数组，其中的元素与车牌信息数组中的对应
     *  @return 0表示成功，-1表示失败
     *  @note   如果需要该回调函数返回截图内容 pImgFull 和pImgPlateClip，需要在设置回调函数（VzLPRClient_SetPlateInfoCallBack）时允许截图内容，否则该回调函数返回的这两个指针为空；
     *  @note   实时结果（VZ_LPRC_RESULT_REALTIME）的回调是不带截图内容的
     *  @ingroup group_callback
     */
    public static interface VZLPRC_PLATE_INFO_CALLBACK extends StdCallCallback{
        public void invoke(int handle,Pointer pUserData,LPR.TH_PlateResult_Pointer.ByReference pResult,int uNumPlates,
                           int eResultType,LPR.VZ_LPRC_IMAGE_INFO_Pointer.ByReference pImgFull,LPR.VZ_LPRC_IMAGE_INFO_Pointer.ByReference pImgPlateClip);
    }
}
