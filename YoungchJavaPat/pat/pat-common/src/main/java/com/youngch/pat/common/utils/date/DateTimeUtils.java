package com.youngch.pat.common.utils.date;

import java.text.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTimeUtils {

    /**
     * 根据年/月/日 时/分/秒 格式获取当前时间
     *
     * @return
     */
    public static Date getCurrentDate() {
        Date createdDate = null;
        try {
            String datestr = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            createdDate = sdf.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return createdDate;
    }

    /**
     * 将日期转化格式，如2015年9月14日10:37:56转化为"14/周一"
     *
     * @param cal
     * @return
     */
    public static String getChineseWeekDays(Calendar cal) {
        String ret;
        int int_day_of_month = cal.get(Calendar.DAY_OF_MONTH);
        DecimalFormat df = new DecimalFormat("#00");
        String str_day_of_month = df.format(int_day_of_month);
        int int_day_of_week = cal.get(Calendar.DAY_OF_WEEK);
        String str_day_of_week = "";
        switch (int_day_of_week) {
            case 1:
                str_day_of_week = "周一";
                break;
            case 2:
                str_day_of_week = "周二";
                break;
            case 3:
                str_day_of_week = "周三";
                break;
            case 4:
                str_day_of_week = "周四";
                break;
            case 5:
                str_day_of_week = "周五";
                break;
            case 6:
                str_day_of_week = "周六";
                break;
            case 7:
                str_day_of_week = "周日";
                break;
            default:
                break;
        }
        ret = str_day_of_month + "/" + str_day_of_week;
        return ret;
    }

    /**
     * 加一天
     */
    public static String plusOneDay(String day) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if (day.length() != 0 && null != day) {
            try {
                Date dd = df.parse(day);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dd);
                calendar.add(Calendar.DAY_OF_MONTH, 1);// 加一天
                String outd = df.format(calendar.getTime());
                return outd;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    /**
     * 减一天
     */
    public static String minusOneDay(String day) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if (day.length() != 0 && null != day) {
            try {
                long dif = df.parse(day).getTime() - 86400 * 1000;// 减一天
                Date date = new Date();
                date.setTime(dif);
                String outd = df.format(date);
                return outd;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    /**
     * 加一天
     */
    public static Date plusOneDay(Date date) {
        if (null != date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, +1);
            date = calendar.getTime();
            return date;
        }
        return null;
    }

    /**
     * 减一天
     */
    public static Date minusOneDay(Date date) {
        if (null != date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, -1);
            date = calendar.getTime();
            return date;
        }
        return null;
    }

    /**
     * Get first day of next month of the pass in date
     *
     * @return
     */
    public static Date nextMonthFirstDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    /**
     * Get first day of the pass in year. month
     *
     * @return
     */
    public static Date currentMonthFirstDate(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1, 0, 0, 0);
        return calendar.getTime();
    }

    /**
     * Check if current date between start and enddate
     *
     * @param startDate
     * @param endDate
     * @return true if between, otherwise false
     */
    public static boolean between(Date startDate, Date endDate) {
        long curTM = System.currentTimeMillis();
        if (startDate.getTime() <= curTM && endDate.getTime() + 86400000 >= curTM) {
            return true;
        }
        return false;
    }

    /**
     * date2比date1多的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2)   //同一年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)    //闰年
                {
                    timeDistance += 366;
                } else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else    //不同年
        {
            return day2 - day1;
        }
    }

    /**
     * 判断时间是否在时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        if (date.after(begin) && date.before(end)) {
            return true;
        } else if (nowTime.compareTo(beginTime) == 0 || nowTime.compareTo(endTime) == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断时间是不是今天
     *
     * @param date
     * @return 是返回true，不是返回false
     */
    public static boolean isToday(Date date) {
        //当前时间
        Date now = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        //获取今天的日期
        String nowDay = sf.format(now);
        //对比的时间
        String day = sf.format(date);

        return day.equals(nowDay);

    }

    public static String pointTime() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(new Date());
    }

    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * @param start 开始日期
     * @param end   结束日期
     * @return List集合
     * @doc 获取日期间的日期
     */
    public static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<Date>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        //添加或减去指定的时间给定日历领域，基于日历的规则。例如，从日历当前的时间减去5天，您就可以通过
        tempStart.add(Calendar.DAY_OF_YEAR, 0);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        tempEnd.add(Calendar.DAY_OF_YEAR, 1);
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }


    public static boolean isOverlap(String startdate1, String enddate1, String startdate2, String enddate2) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date leftStartDate = null;
        Date leftEndDate = null;
        Date rightStartDate = null;
        Date rightEndDate = null;
        try {
            leftStartDate = format.parse(startdate1);
            leftEndDate = format.parse(enddate1);
            rightStartDate = format.parse(startdate2);
            rightEndDate = format.parse(enddate2);
        } catch (ParseException e) {
            return false;
        }
        if (leftStartDate.getTime() <= rightStartDate.getTime() && leftEndDate.getTime() >= rightStartDate.getTime()) {
            return true;
        } else if (leftStartDate.getTime() >= rightStartDate.getTime() && leftStartDate.getTime() <= rightEndDate.getTime()) {
            return true;
        } else {
            return false;
        }

    }

    public static Date timestamp(Date date, int h, int m, int s) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, h);
        calendar.set(Calendar.MINUTE, m);
        calendar.set(Calendar.SECOND, s);
        return calendar.getTime();
    }

    public static long getNextDateTime(int d, int h) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR, d);
        cal.set(Calendar.HOUR_OF_DAY, h);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime().getTime();
    }

    public static long date2TimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(date_str).getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getDateTime(Date t) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(t);
    }

    public static String getAfterDayTime(int day, int h, int m, int s) {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        now.set(Calendar.HOUR_OF_DAY, h);
        now.set(Calendar.MINUTE, m);
        now.set(Calendar.SECOND, s);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(now.getTime()));
        return df.format(now.getTime());
    }


    public static void main(String[] args) {
        getAfterDayTime(2, 10, 0, 0);
    }

}



