package com.youngch.pat.common.utils.encode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncodeUtils {

    private static Logger logger = LoggerFactory.getLogger(EncodeUtils.class);

    /**
     * 使用MD5加密+Base64编码
     * @param sourceText
     * @return
     */
    public static String encodeByMD5Base64(String sourceText){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            logger.error("no md5 digest:", e);
        }
        byte[] b = md.digest(sourceText.getBytes());
        BASE64Encoder be = new BASE64Encoder();
        be.encode(b);
        return be.encode(b);
    }

    public static String unicodeEncode(String content) {
        StringBuilder sb = new StringBuilder(content.length() * 3);
        for (char c : content.toCharArray()) {
            if (c < 256) {
                sb.append(c);
            } else {
                sb.append("\\u");
                sb.append(Character.forDigit((c >>> 12) & 0xf, 16));
                sb.append(Character.forDigit((c >>> 8) & 0xf, 16));
                sb.append(Character.forDigit((c >>> 4) & 0xf, 16));
                sb.append(Character.forDigit((c) & 0xf, 16));
            }
        }
        return sb.toString();
    }

    public static String unicodeDecode(String unicode){
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;

        while((i=unicode.indexOf("\\u", pos)) != -1){
            sb.append(unicode.substring(pos, i));
            if(i+5 < unicode.length()){
                pos = i+6;
                sb.append((char)Integer.parseInt(unicode.substring(i+2, i+6), 16));
            }
        }

        return sb.toString();
    }
}
