package com.xk72.charles.gui.transaction.general;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by sunxiaoyang@cmcm.com
 * 2021/12/30 15:42
 */
public class AES {

    public static String m6254a(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(1, secretKeySpec);
            return Base64.encodeToString(instance.doFinal(str.getBytes("utf-8")), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decode(String str, String str2) {
        if (null == str || str.isEmpty()) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, secretKeySpec);
            return new String(instance.doFinal(decode));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decode(String str, String str2, String str3) {
        if (null == str || str.isEmpty()) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return new String(instance.doFinal(decode));
        } catch (Throwable th) {
            return null;
        }
    }

    public static String m6253a(String str) {
        if (str == null || str.length() != 16) {
            return null;
        }
        return str.concat(str).substring(8, 24);
    }

    public static String m9057a(String str) {
        if (str == null || str.length() != 16) {
            return null;
        }
        return str.concat(str).substring(8, 24);
    }
}
