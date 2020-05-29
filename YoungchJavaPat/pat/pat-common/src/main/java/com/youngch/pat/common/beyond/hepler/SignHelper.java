package com.youngch.pat.common.beyond.hepler;

import com.youngch.pat.common.beyond.model.request.ApiReqModel;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class SignHelper {
    public static void Sign(ApiReqModel requestCommonModel, String appKey) {
        try {
            HashMap<String, String> map = new HashMap<String, String>();
            Class<?> type = requestCommonModel.getClass();
            Field[] fields = type.getDeclaredFields();
            String signType = "";

            for (Field f : fields) {
                String fName = f.getName();
                char[] fNameCharArray = fName.toCharArray();
                if (fNameCharArray.length > 0 && Character.isLowerCase(fNameCharArray[0])) {
                    fNameCharArray[0] = Character.toUpperCase(fNameCharArray[0]);
                }
                if (fName.equalsIgnoreCase("SignType")) {
                    f.setAccessible(true);
                    signType = f.get(requestCommonModel).toString();
                }
                if (!f.getName().equalsIgnoreCase("sign")) {
                    Object value = null;
                    try {
                        f.setAccessible(true);
                        value = f.get(requestCommonModel);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    if (value != null) {
                        map.put(new String(fNameCharArray), value.toString());
                    }
                }
            }
            String formString = GetFormString(map);
            formString += appKey;

            String sign = "";

            if (signType.equalsIgnoreCase("SHA256")) {
                sign = CryptographHelper.SHA256(formString);
            } else {
                sign = CryptographHelper.MD5(formString);
            }

            requestCommonModel.setSign(sign);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static String GetFormString(HashMap<String, String> map) throws UnsupportedEncodingException {
        StringBuilder builder = new StringBuilder();
        SortedMap<String, String> sortedMap = new TreeMap<>(map);
        Iterator<Map.Entry<String, String>> it = sortedMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
//            if (entry.getKey().equalsIgnoreCase("sign")) {
//                continue;
//            }
//            builder.append(String.format("%s=%s&", entry.getKey(), URLEncoder.encode(entry.getValue(),"GBK")));
            builder.append(String.format("%s=%s&", entry.getKey(), entry.getValue()));
        }
        String result = builder.toString();
        if (result.endsWith("&")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}
