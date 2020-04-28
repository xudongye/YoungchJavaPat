package com.youngch.pat.common.utils.price;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;


public class PriceUtils {

    /***
     * Convert float value to decimal with specified bits behind point
     * @param value
     * @param numOfPoints the number of bits behind point
     * @return
     */
    public static float ConvertDecimalPoint(float value, int numOfPoints){
        if(numOfPoints < 0){
            return value;
        }

        return new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_DOWN).floatValue();
    }

    /***
     * Convert double value to decimal with specified bits behind point
     * @param value
     * @param numOfPoints the number of bits behind point
     * @return
     */
    public static double ConvertDecimalPoint(double value, int numOfPoints){
        if(numOfPoints < 0){
            return value;
        }

        return new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    /***
     * Eliminate the dot number of float value
     * @param number
     * @return
     */
    public static float MathRound(float number) {
        return (float)(Math.round(number * 100))/100;
    }

    /***
     * Eliminate the dot number of double
     * @param number
     * @return
     */
    public static double MathRound(double number) {
        return (double)(Math.round(number * 100))/100;
    }

    public static String fenToYuan(String amount){
        NumberFormat format = NumberFormat.getInstance();
        try{
            Number number = format.parse(amount);
            double temp = number.doubleValue() / 100.0;
            format.setGroupingUsed(false);
            // 设置返回的小数部分所允许的最大位数
            format.setMaximumFractionDigits(2);
            amount = format.format(temp);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return amount;
    }

}
