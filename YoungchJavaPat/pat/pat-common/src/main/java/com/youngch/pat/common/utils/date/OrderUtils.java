package com.youngch.pat.common.utils.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 使用系统日期生产流水单号
 * 规则：年月日+时分秒+毫秒+四位随机数+一个大写随机字母
 * 例如：201805171225091660098Q
 *
 * @author yexudong
 * @date 2018/5/17 19:08
 */
public class OrderUtils {

    public static String getOrderSn() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String sn = format.format(date);
        String letter[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        //添加四个随机数
        for (int i = 1; i < 5; i++) {
            sn += Math.floor(Math.random() * 10);
        }
        //添加一个随机字母
        sn += letter[new Random().nextInt(26)];
        return sn.replace(".0", "");
    }

}
