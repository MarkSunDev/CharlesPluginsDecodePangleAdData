package com.xk72.charles.gui.transaction.general;

/**
 * Created by sunxiaoyang@cmcm.com
 * 2021/12/30 15:41
 */
public class ToolUtils {

    /**
     * 解密
     * @param str
     * @return
     */
    public static String decryption(String str) {
        if (str == null || str.length() < 17) {
            return str;
        }
        return AES.decode(str.substring(17), m6353c(str.substring(1, 17)));
    }

    public static String decode(String str) {
        if (str == null || str.length() < 17) {
            return null;
        }
        return AES.decode(str, AESKey.key1());
    }

    public static String decodeAdData(String str) {
        if (null == str || str.length() < 49) {
            return str;
        }
        String a = m4074a(str.substring(1, 33), 32);
        String substring = str.substring(33, 49);
        return (substring == null || a == null) ? str : AES.decode(str.substring(49), substring, a);
    }

    public static String m4074a(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    private static String m6353c(String str) {
        String a = AES.m6253a(str);
        if (str != null) {
            return a;
        }
        String a2 = AESKey.key1();
        return a2.concat(a2).substring(8, 24);
    }

}
