package com.coalvalue.configuration;

public class Constants {
	/**
	 * 常量说明：
	 * 此处定义的常量需要持久化，可以保存在数据库中，在需要的地方读取。
	 * 在多企业号中，最好以每个应用来定义。
     *     * 发送模板消息
     * appId 公众账号的唯一标识
     * appSecret 公众账号的密钥
     * openId 用户标识
	 */


	public static final int AGENTID = 1;
	public static final String TOKEN = "zhaoyuansb";



 	public static String APP_ID = "7m30VKHKMF001AKERNVm";




    public static  String APP_SECRET = "46wknBRx80XPKJ7ROPekUsWLusMqorvGF10i1t6ZyH73JFsqPG";


   //public static final String APP_SECRET = "24dc8bd2a102e5f92acc8dda3c06b189";


    public static  String encodingAESKey = null;// "WrvQ9ppFmtm18ZiQ0x297Xq0gLOX0eT0awXpltIZ6zI";

    public static  String HOST_WEBSITE = "http://c39b3f73.ngrok.io";
    public static  String HOST_WEBSITE_local = "http://192.168.1.5:8085";

    static {

        APP_ID = "7m30VKHKMF001AKERNVm";// 生产系统
            APP_SECRET = "46wknBRx80XPKJ7ROPekUsWLusMqorvGF10i1t6ZyH73JFsqPG";
            encodingAESKey = "WrvQ9ppFmtm18ZiQ0x297Xq0gLOX0eT0awXpltIZ6zI";
            HOST_WEBSITE = "http://yulinmei.cn";

    }


    public static final String WORDS_OF_WELCOME = " \"感谢您关注【易找煤】\\n微信号：yizhaomei\";";

    public static final String STATUE_UNSUBSCRIBE = "UnSubScribe";
    public static final String STATUE_SUBSCRIBE = "SubScribe";



    public static final int MAX_CONTEXT_NUM = 100;
    public static final int WX_COMPANY_SCENEID = 10000;
    public static final String WX_QRCODE_TYPE_COMPANY = "company";



}
