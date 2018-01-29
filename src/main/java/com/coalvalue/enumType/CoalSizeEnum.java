package com.coalvalue.enumType;

import com.coalvalue.domain.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/2.
 */
public enum CoalSizeEnum {


/*
    2.1.15  特大块  Uitra large coal(>100mm)  大于100mm的粒级煤        2.1.16  大块煤  Large coal(>50mm)  大于50mm的粒级煤       
             2.1.17  中块煤  Medium-sizldcoal(25～50mm)  5～50mm的粒级煤        
            2.1.18  小块煤  Small coal(13～25mm)  13～25mm的粒级煤       
             
            2.1.19  混中块  Mixed medium-sized coal (13～80mm)  13～80mm的粒级煤        
            2.1.20  混块  Mixedlumpcoal(13～300mm)  13～300mm之间的粒级煤        
            2.1.21  粒煤  Pea coal(6～13mm)  6～13mm的粒级煤       
             2.1.22  混煤  Mixed coal(>0～50mm)  0～50mm之间的煤        
            2.1.23  末煤  Slack;slack coal(>0～25mm)  0～25mm之间的煤       
             
            2.1.24  粉煤  Fine coal(>0～6mm)  0～6mm之间的煤       
             2.1.25  煤粉  Coal fines(>0～0.5mm)  小于0.5mm的煤       
             
            2.1.26  煤泥  slime  煤经洗选或水采后粒度在0.5mm以下的产品
    粉煤：粒度小于6mm的煤
    沫煤：粒度小于25mm或13mm的煤
    20~50mm二五块煤
    30~60mm三六块煤
    30~80mm三八块煤
    40~90mm四九块煤
    100~250mm中块煤
    250mm以上大块煤*/


    FINE_COAL ("粒煤","粒煤",1,"6～13mm的粒级煤"),
    COAL_FINES ("煤粉","煤粉",2,"小于0.5mm的煤"),

    SLIME ("煤泥","煤泥", 3,"煤经洗选或水采后粒度在0.5mm以下的产品"),
    ERWU ("二五块","二五块", 4,"20~50mm"),
    SANLIU ("三六块","三六块", 5,"30~60mm"),
    SANBA ("三八块","三八块", 6,"30~80mm"),
    SIJIU ("四九块","四九块", 7,"40~90mm"),
    八一五块 ("八一五块","八一五块", 8,"80~150mm"),
    MEDIUM_SIZE ("中块","中块", 9,"100~250mm"),
    LARGE ("大块","大块", 10,"250mm"),
    H_LARGE ("混块","混块", 11,"13～300mm之间的粒级煤"),
    H_MEDIUM ("混中块","混中块", 12,"13～80mm的粒级煤"),
    H_FINN ("混沫块","混沫块", 13,"混沫块"),

    H ("混煤","混煤", 14,"0～50mm之间的煤"),




    二五籽煤 ("二五籽煤","二五籽煤", 15,"20~50mm"),
    面煤 ("面煤","面煤", 16,"0～25mm之间的煤"),





    过筛面煤 ("过筛面煤","过筛面煤", 17,"过筛面煤"),
    煤泥 ("煤泥","煤泥", 18,"煤泥"),
    水洗面煤 ("水洗面煤","水洗面煤", 19,"水洗面煤"),
    水洗13籽 ("水洗1-3籽","水洗1-3籽", 20,"水洗1-3籽"),

    水洗36籽 ("水洗3-6籽","水洗3-6籽", 21,"水洗3-6籽"),
    八一五块815块 ("8-15块","8-15块", 22,"8-15块"),

    H_5_15 ("H_5_15","5-15混块", 23,"5-15混块"),
    H_2_5 ("H_2_5","2-5混块", 24,"2-5混块");

    private final String statusText;
    private final String displayText;
    private final Integer id;

    private String helpMessage;
    private String tipsMessage;

    public void setTipsMessage(String tipsMessage) {
        this.tipsMessage = tipsMessage;
    }


    public String getDisplayText() {
        return displayText;
    }

    private CoalSizeEnum(String statusText, String displayText, Integer id, String tipsMessage) {
        this.statusText = statusText;
        this.displayText = displayText;

        this.id = id;
        this.tipsMessage = tipsMessage;
    }
    public String getText() {
        return this.statusText;
    }

    public Integer getId() {
        return this.id;
    }


    public static List<ListItem> retriveTypese() {

        List<ListItem> list = new ArrayList<ListItem>();
        for (CoalSizeEnum status : CoalSizeEnum.values()) {
            ListItem element = new ListItem(status.getText(), status.getDisplayText(), status.getTipsMessage());
            list.add(element);
        }

        return list;

    }

    public static CoalSizeEnum fromString(String text) {
        for (CoalSizeEnum status : CoalSizeEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static List<String> getIds(List<CoalSizeEnum> allTypeForCompany) {

        List<String> ids = new ArrayList<String>();

        for (CoalSizeEnum status : allTypeForCompany) {

            ids.add(status.getText());

        }
        return ids;
    }

    public static List<ListItem> retriveTypese(String scene) {
        List<ListItem> list = new ArrayList<ListItem>();



        if (ContextStateEnum.CONTEXT_SCENE_coal_size_hengshan_separation_area.name().equals(scene)) {
            ListItem element = new ListItem(过筛面煤.getText(), 过筛面煤.getDisplayText(), 过筛面煤.getTipsMessage());
            list.add(element);
            element = new ListItem(煤泥.getText(), 煤泥.getDisplayText(), 煤泥.getTipsMessage());
            list.add(element);
            element = new ListItem(水洗面煤.getText(), 水洗面煤.getDisplayText(), 水洗面煤.getTipsMessage());
            list.add(element);
            element = new ListItem(水洗13籽.getText(), 水洗13籽.getDisplayText(), 水洗13籽.getTipsMessage());

            list.add(element);
            element = new ListItem(水洗36籽.getText(), 水洗36籽.getDisplayText(), 水洗36籽.getTipsMessage());

            list.add(element);
            element = new ListItem(八一五块815块.getText(), 八一五块815块.getDisplayText(), 八一五块815块.getTipsMessage());
            list.add(element);

        }

        if (ContextStateEnum.CONTEXT_SCENE_coal_size_hengshan_area.name().equals(scene)) {
            ListItem element = new ListItem(面煤.getText(), 面煤.getDisplayText(), 面煤.getTipsMessage());
            element.setSelected(true);
            list.add(element);
            element = new ListItem(二五籽煤.getText(), 二五籽煤.getDisplayText(), 二五籽煤.getTipsMessage());
            list.add(element);
            element = new ListItem(SANBA.getText(), SANBA.getDisplayText(), SANBA.getTipsMessage());
            list.add(element);
            element = new ListItem(八一五块.getText(), 八一五块.getDisplayText(), 八一五块.getTipsMessage());

            list.add(element);
            element = new ListItem(LARGE.getText(), LARGE.getDisplayText(), LARGE.getTipsMessage());

            list.add(element);

        }
        return list;
    }

    public String getTipsMessage() {
        return tipsMessage;
    }
}
