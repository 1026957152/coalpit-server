package com.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhongkw on 1/18/2015.
 */
public class MD5Util {

    protected static transient Log logger = LogFactory.getLog(MD5Util.class);

    protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    protected static MessageDigest messagedigest = null;

    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            if (logger.isDebugEnabled()) {
                logger.debug(MD5Util.class.getName() + "初始化失败，MessageDigest不支持MD5。");
                ex.printStackTrace();
            }
        }
    }

    public static String getMD5StringWithSalt(String password, String salt) {
        if (StringUtil.isEmpty(password)) {
            throw new IllegalArgumentException("password不能为null");
        }
        if (StringUtil.isEmpty(salt)) {
            throw new IllegalArgumentException("salt不能为空");
        }
        if ((salt.toString().lastIndexOf("{") != -1)
                || (salt.toString().lastIndexOf("}") != -1)) {
            throw new IllegalArgumentException("salt中不能包含 { 或者 }");
        }
        return getMD5String(password + "{" + salt.toString() + "}");
    }

    public static String getMD5String(String str) {
        return getMD5String(str.getBytes());
    }

    private static String getMD5String(byte[] bytes) {
        messagedigest.update(bytes);
        return bufferToHex(messagedigest.digest());
    }

    private static String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 0xf0) >> 4];
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }
}
