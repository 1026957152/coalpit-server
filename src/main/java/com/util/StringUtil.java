package com.util;

/**
 * Created by zhongkw on 1/18/2015.
 */
public class StringUtil {

    public static boolean isEmpty(String chkStr) {
        if (chkStr == null) {
            return true;
        } else {
            return "".equals(chkStr.trim()) ? true : false;
        }
    }
}
