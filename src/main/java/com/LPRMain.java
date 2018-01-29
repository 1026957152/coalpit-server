package com;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import com.sun.jna.Pointer;

public class LPRMain {

    static LPR lpr = LPR.INSTANCE;
    VZLPRC_PLATE_INFO_CALLBACK PlateCallBack = new VZLPRC_PLATE_INFO_CALLBACK();

    public LPRMain(){
        InitClient();
    }

    public static void main(String[] args) throws Exception {
        LPRMain lprtest = new LPRMain();
    }

    private void InitClient(){
        try{
            lpr.VzLPRClient_Setup();
            String ip = "192.168.1.100";
            String admin = "admin";
            String password = "admin";
            int handle = lpr.VzLPRClient_Open(ip, 80, admin, password);

            if(handle == 0)
                System.out.println("���豸ʧ��");
            else
                System.out.println("�ɹ����豸");

            int callbackindex = lpr.VzLPRClient_SetPlateInfoCallBack(handle, PlateCallBack, Pointer.NULL, 0);
            System.out.println(callbackindex);


            AddWlistPlate( handle );

            Scanner input = new Scanner(System.in);

            int end = input.nextInt();
            System.out.println(end);
        }
        catch(Exception e)
        {
            System.out.println("Error:"+e);
        }
    }

    // ��Ӱ�����
    private int AddWlistPlate( int handle )
    {
        int ret = 0;

        try
        {
            LPR.VZ_LPR_WLIST_VEHICLE.ByReference wlistVehicle = new LPR.VZ_LPR_WLIST_VEHICLE.ByReference();

            wlistVehicle.strPlateID[0] = '1';
            wlistVehicle.strPlateID[1] = '2';
            wlistVehicle.strPlateID[2] = '3';
            wlistVehicle.strPlateID[3] = '4';
            wlistVehicle.strPlateID[4] = '5';

            wlistVehicle.uCustomerID	= -1;
            wlistVehicle.bEnable		= 1;


            LPR.VZ_TM.ByReference struTMOverdule = new LPR.VZ_TM.ByReference();
            struTMOverdule.nYear	= 2015;
            struTMOverdule.nMonth	= 12;
            struTMOverdule.nMDay	= 30;
            struTMOverdule.nHour	= 12;
            struTMOverdule.nMin		= 40;
            struTMOverdule.nSec		= 50;

            wlistVehicle.pStruTMOverdule	= struTMOverdule;
            wlistVehicle.bUsingTimeSeg	= 0;
            wlistVehicle.bAlarm			= 1;

            wlistVehicle.strCode[0] = '1';
            wlistVehicle.strCode[1] = '2';
            wlistVehicle.strCode[2] = '3';
            wlistVehicle.strCode[3] = '4';
            wlistVehicle.strCode[4] = '5';

            LPR.VZ_LPR_WLIST_ROW.ByReference wlistRow	= new LPR.VZ_LPR_WLIST_ROW.ByReference();
            wlistRow.pVehicle = wlistVehicle;
            wlistRow.pCustomer = null;
            LPR.VZ_LPR_WLIST_IMPORT_RESULT.ByReference importResult = new LPR.VZ_LPR_WLIST_IMPORT_RESULT.ByReference();
            ret = lpr.VzLPRClient_WhiteListImportRows(handle, 1, wlistRow, importResult);
        }
        catch(Exception e)
        {
            System.out.println("Error:"+e);
        }

        return ret;
    }

    public static String deCode(String str) {
        try {
            return java.net.URLDecoder.decode(str, "GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public class VZLPRC_PLATE_INFO_CALLBACK implements LPR.VZLPRC_PLATE_INFO_CALLBACK
    {
        public void invoke(int handle,Pointer pUserData,LPR.TH_PlateResult_Pointer.ByReference pResult,int uNumPlates,
                           int eResultType,LPR.VZ_LPRC_IMAGE_INFO_Pointer.ByReference pImgFull,LPR.VZ_LPRC_IMAGE_INFO_Pointer.ByReference pImgPlateClip)
        {
            int type = LPR.VZ_LPRC_RESULT_TYPE.VZ_LPRC_RESULT_REALTIME.ordinal();
            if(eResultType != type)
            {
                String license = new String(pResult.license);
                String licenseres = deCode(license).trim();
                System.out.println(licenseres);
                String path = "./" + pResult.struBDTime.bdt_year + pResult.struBDTime.bdt_mon
                        + pResult.struBDTime.bdt_mday + pResult.struBDTime.bdt_hour
                        + pResult.struBDTime.bdt_min + pResult.struBDTime.bdt_sec
                        + licenseres + ".jpg";
                int SaveRet = lpr.VzLPRClient_ImageSaveToJpeg(pImgFull, path, 100);
            }

        }
    }

}
