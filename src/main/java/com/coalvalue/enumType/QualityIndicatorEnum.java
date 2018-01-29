package com.coalvalue.enumType;

import com.coalvalue.domain.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/1/18.
 */
public enum QualityIndicatorEnum {






    Mt ("Mt", "全水份（Mt）","%","report_mt",2,""),
    Mad ("Mad","空气干燥基水份(Mad)","%", "report_mad",2,""),
    Mf ("Mf","外水分(Mf)","%", "report_aad",2,""),


    Aad ("Aad","空气干燥基灰分（Aad）","%","report_aad", 2,""),
    Ad ("Ad","干燥基灰分（Ad）","%","report_ad", 2,""),// 请求结算
    Aar ("Aar","收到基灰分","%","report_aar", 2,""),

    Vad ("Vad", "空气干燥基挥发份（Vad）","%","report_vad",2,""),
    Vd ("Vd","干燥基挥发份（Vd）","%", "report_vd",2,""),
    Vdaf ("Vdaf","干燥无灰基挥发份（Vdaf）","%","report_vdaf", 2,""),
    Var ("Var", "收到基挥发份（Var）","%","report_var",2,""),





    St ("St","全硫(St）","%", "report_st",2,""),

    Stad ("St,ad","空气干燥基全硫(St,ad）","%", "report_stad",2,""),
    Std ("St.d","干燥基全硫(St.d)","%","report_std", 2,""),
    Star ("St,ar", "收到基全硫(St,ar)","%","report_star",2,""),

    Fc ("Fc","固定碳","%","report_fc", 2,""),
    FCd ("FCd", "干基固定碳(Fcd)","%","申请中",2,""),
    FCar ("FCar", "收到基固定碳(FCar)","%","申请中",2,""),


    Qbad ("Qb,ad", "空干基弹筒发热量(Qb,ad)","kcal/kg","申请中",2,""),
    Qbd ("Qb,d", "干燥基弹筒发热量(Qb,d)","kcal/kg","report_qb",2,""),
    Qbar ("Qb,ar", "收到基弹筒发热量(Qb,ar)","kcal/kg","申请中",2,""),
    Qbdaf ("Qb,daf", "干燥无灰基弹筒发热量(Qb,daf)","kcal/kg","申请中",2,""),


    Qgr ("Qgr","高位发热量(Qgr)","kcal/kg","report_qgr", 2,""),
    Qgrad ("Qgr,ad","空干基高位发热量(Qgr,ad)","kcal/kg","report_qgrad", 2,""),
    Qgrdaf ("Qgr,daf", "干燥无灰基高位发热量(Qgr,daf)","kcal/kg","report_qgrdaf",2,""),
    Qgrd ("Qgr,d", "干基高位发热量(Qgr,d)","kcal/kg","report_qgrd",2,""),


    Qmaf ("Qmaf", "恒温无灰基高位发热量(Qmaf)","kcal/kg","report_qmaf",2,""),



    Qnet ("Qnet", "恒温无灰基低位发热量(Qnet)","kcal/kg","report_qnet",2,""),
    Qnetad ("Qnet,ad", "分析基低位发热量(Qnet,ad)","kcal/kg","申请中",2,""),
    Qnetar ("Qnet,ar","收到基低位发热量(Qnet,ar)","kcal/kg","report_qnetar", 2,""),
    Qnetdaf ("Qnet,daf","干燥无灰基低位发热量(Qnet,daf)","kcal/kg","已到场", 2,""),



    HGI ("HGI","可磨性（HGI)","","已到场", 2,""),

    灰熔点 ("灰熔点", "灰熔点(Qgr,daf)","","申请中",2,""),
    ARD ("ARD", "煤的绝对密度(ARD)","t/m3","申请中",2,""),
    TRD ("TRD", "煤的相对密度(TRD)","t/m3","申请中",2,""),
    燃点 ("燃点", "燃点","℃","申请中",2,""),// 请求结算

    Hdaf ("Hdaf","氢含量","","report_hdaf", 2,""),

    CRC ("CRC","焦渣特征（CRC1-8)","","report_crc", 2,"结指数与焦渣特征结果间的互审 焦渣特征是在测挥发分的同时所获得，并用来判断煤粘结性强弱的定性指标，它与各种粘结性指标间总的趋势都是呈正比关系变化。1、粉状。全部是粉末，没有相互粘着的颗粒； \n" +
            "2、粘着。用手指轻碰即成为粉末状或基本上是粉末状，其中较大的团块轻轻一碰机即成粉末。 \n" +
            "3、弱粘性。用手指轻压即成小块； \n" +
            "4、不熔融粘结。用手指用力压才裂成小块，焦渣上表面无光泽，下表面稍微有银白色光泽； \n" +
            "5、不膨胀熔融粘结。焦渣形成扁平的块，煤粒的界限不易分清。焦渣上表面有明显的银白色金属光泽，下表面银白色光泽更明显； \n" +
            "6、微膨胀熔融粘结。用手指压不碎，焦渣的上、下表面均有银白色金属光泽。但是焦渣表面具有较小的膨胀泡； \n" +
            "7、膨胀熔融粘结。焦渣上下表面均有银白色金属光泽，明显膨胀，但高度不超过15mm； \n" +
            "8、强膨胀熔融粘结。焦渣上、下表面有银白色金属光泽，焦渣高度超过15mm。 "),
    AFT ("AFT","灰熔点(AFT)","","report_crc", 2,""),

    G ("G","粘结指数(G)","","report_crc", 2,"结指数与焦渣特征结果间的互审 焦渣特征是在测挥发分的同时所获得，并用来判断煤粘结性强弱的定性指标，它与各种粘结性指标间总的趋势都是呈正比关系变化。"),
    Y ("Y","胶质层厚度(Y)","","report_crc", 2,""),
    Shale_content ("Shale_content","含矸率","","report_shale_content", 2,""),
    灰熔点软度 ("灰熔点软度","灰熔点软度","","灰熔点软度", 2,""),
    和焦油分产率 ("和焦油分产率","和焦油分产率","","和焦油分产率", 2,"Tar，d或Tar，daf表示,焦油产率是评价低温干馏用煤的主要依据，一般要求Tar，d不低于7%。变质程度低，挥发分高的煤，焦油产率也较高，腐泥煤的焦油产率比同变质程度的腐殖煤高。");



    private final String symbol;
    private final String displayText;

    private final String unit;
    private final String statusText;
    public String getStatusText() {
        return statusText;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getUnit() {
        return unit;
    }

    private final Integer id;

    private String helpMessage;

    public String getHelpMessage() {
        return helpMessage;
    }

    public void setHelpMessage(String helpMessage) {
        this.helpMessage = helpMessage;
    }

    public String getDisplayText() {
        return displayText;
    }

    private QualityIndicatorEnum(String symbol, String displayText, String unit, String statusText, Integer id, String helpMessage) {
        this.statusText = statusText;
        this.displayText = displayText;
        this.symbol = symbol;
        this.unit = unit;
        this.id = id;
        this.helpMessage = helpMessage;
    }
    public String getText() {
        return statusText;
    }

    public Integer getId() {
        return this.id;
    }

    public static List<ListItem> retriveTypese() {

        List<ListItem> list = new ArrayList<ListItem>();
        for (QualityIndicatorEnum status : QualityIndicatorEnum.values()) {
            ListItem element = new ListItem(status.getSymbol(), status.getDisplayText(), status.getHelpMessage());
            list.add(element);
        }

        return list;

    }

    public static List<ListItem> retriveTypese(int i) {

        List<ListItem> list = new ArrayList<ListItem>();


            ListItem element = new ListItem(Mad.getSymbol(), Mad.getDisplayText(), Mad.getHelpMessage());
            list.add(element);


        element = new ListItem(Ad.getSymbol(), Ad.getDisplayText(), Ad.getHelpMessage());
        list.add(element);
        element = new ListItem(Vdaf.getSymbol(), Vdaf.getDisplayText(), Vdaf.getHelpMessage());
        list.add(element);


        element = new ListItem(Std.getSymbol(), Std.getDisplayText(), Std.getHelpMessage());
        list.add(element);
        element = new ListItem(Qnetar.getSymbol(), Qnetar.getDisplayText(), Qnetar.getHelpMessage());
        list.add(element);
        return list;

    }


    public static List<ListItem> retriveTypese(String statusText) {

        List<ListItem> list = new ArrayList<ListItem>();
        for(QualityIndicatorEnum status : QualityIndicatorEnum.values()) {
            ListItem element = new ListItem(status.getText(), status.getDisplayText());
            if (status.getText().equals(statusText)){
                element.setSelected(true);
            }
            list.add(element);
        }
        return list;

    }
    public static QualityIndicatorEnum fromString(String text) {
        for (QualityIndicatorEnum status : QualityIndicatorEnum.values()) {
            if (status.getSymbol().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static List<String> toStringList(List<QualityIndicatorEnum> created) {

        List<String> status = new ArrayList<>();
        for(QualityIndicatorEnum canvassingStatusEnum : created){
            status.add(canvassingStatusEnum.getText());
        }
        return status;
    }
}
