package com.youngch.pat.common.beyond.hepler;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class CryptographHelper {
    public static String MD5(String signString) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] bytes = digest.digest(signString.getBytes("utf-8"));
        return toHex(bytes);
    }

    private static String toHex(byte[] bytes)
    {
        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder stringBuilder = new StringBuilder(bytes.length*2);
        for (int i=0;i<bytes.length;i++)
        {
            stringBuilder.append(HEX_DIGITS[(bytes[i]>>4)&0x0f]);
            stringBuilder.append(HEX_DIGITS[bytes[i]&0x0f]);
        }
        return stringBuilder.toString();
    }


    public static String SHA256(String signString) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(signString.getBytes("utf-8"));
        return toHex(digest.digest());
    }
}
