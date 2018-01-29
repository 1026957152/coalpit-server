package com.util;

/**
 * Created by Administrator on 2015/10/7.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    private static final long ONE_MINUTE = 60;
    private static final long ONE_HOUR = 3600;
    private static final long ONE_DAY = 86400;
    private static final long ONE_MONTH = 2592000;
    private static final long ONE_YEAR = 31104000;

    public static Calendar calendar = Calendar.getInstance();

    /**
     * @return yyyy-mm-dd
     * 2012-12-25
     */
    public static String getDate() {
        return getYear() + "-" + getMonth() + "-" + getDay();
    }

    /**
     * @param format
     * @return yyyy年MM月dd HH:mm
     * MM-dd HH:mm 2012-12-25
     */
    public static String getDate(String format) {
        SimpleDateFormat simple = new SimpleDateFormat(format);
        return simple.format(calendar.getTime());
    }


    /**
     * @param format
     * @return yyyy年MM月dd HH:mm
     * MM-dd HH:mm 2012-12-25
     */
    public static String getDate(Date date) {
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        return simple.format(date);
    }

    /**
     * @return yyyy-MM-dd HH:mm
     * 2012-12-29 23:47
     */
    public static String getDateAndMinute() {
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simple.format(calendar.getTime());
    }

    public static String getDateAndMinute(Date date) {
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simple.format(date.getTime());
    }
    public static String getMothenAndDayAndMinute(Date date) {
        SimpleDateFormat simple = new SimpleDateFormat("MM-dd HH:mm");
        return simple.format(date.getTime());
    }
    /**
     * @return yyyy-MM-dd HH:mm:ss
     * 2012-12-29 23:47:36
     */
    public static String getFullDate() {
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simple.format(calendar.getTime());
    }
    public static String getFullDateWithoutYYYY(Date date) {
        SimpleDateFormat simple = new SimpleDateFormat("MM-dd HH:mm:ss");
        return simple.format(date.getTime());
    }

    public static String getFullPMAMDate(Date date) {
        SimpleDateFormat simple = new SimpleDateFormat("MM-dd ahh");
        return simple.format(date.getTime());
    }

    /**
     * 距离今天多久
     *
     * @param date
     * @return
     */
    public static String fromToday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        long time = date.getTime() / 1000;
        long now = new Date().getTime() / 1000;
        long ago = now - time;
        System.out.println("ago：" +ago);
        System.out.println("now：" +now);
        System.out.println("time：" +time);

        System.out.println("-(ONE_DAY)：" +-(ONE_DAY));
        if(ago <= -ONE_DAY*3 )
            return  "将来";
        else if(ago <= -ONE_DAY*2 )
            return  "后天";
        else if(ago <= -(ONE_DAY))
            return  "明天";
        else if (ago <= ONE_MINUTE)
            return "刚刚";
        else if (ago <= ONE_HOUR)
            return ago / ONE_MINUTE + "分钟前";
        else if (ago <= ONE_DAY)
            return ago / ONE_HOUR + "小时" + (ago % ONE_HOUR / ONE_MINUTE)
                    + "分钟前";
        else if (ago <= ONE_DAY * 2)
            return "昨天" + calendar.get(Calendar.HOUR_OF_DAY) + "点"
                   ;// + calendar.get(Calendar.MINUTE) + "分";
        else if (ago <= ONE_DAY * 3)
            return "前天" + calendar.get(Calendar.HOUR_OF_DAY) + "点"
                   ;// + calendar.get(Calendar.MINUTE) + "分";
        else if (ago <= ONE_MONTH) {
            long day = ago / ONE_DAY;
            return day + "天前" + calendar.get(Calendar.HOUR_OF_DAY) + "点"
                    ;//+ calendar.get(Calendar.MINUTE) + "分";
        } else if (ago <= ONE_YEAR) {
            long month = ago / ONE_MONTH;
            long day = ago % ONE_MONTH / ONE_DAY;
            return month + "个月" + day + "天前"
                    + calendar.get(Calendar.HOUR_OF_DAY) + "点"
                   ;// + calendar.get(Calendar.MINUTE) + "分";
        } else {
            long year = ago / ONE_YEAR;
            int month = calendar.get(Calendar.MONTH) + 1;// JANUARY which is 0 so month+1
            return year + "年前" + month + "月" + calendar.get(Calendar.DATE)
                    + "日";
        }

    }


    /**
     * 距离今天多久
     *
     * @param date
     * @return
     */
    public static String fromToday_short(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        long time = date.getTime() / 1000;
        long now = new Date().getTime() / 1000;
        long ago = now - time;
        System.out.println("ago：" +ago);
        System.out.println("now：" +now);
        System.out.println("time：" +time);

        System.out.println("-(ONE_DAY)：" +-(ONE_DAY));
        if(ago <= -ONE_DAY*3 )
            return  "将来";
        else if(ago <= -ONE_DAY*2 )
            return  "后天";
        else if(ago <= -(ONE_DAY))
            return  "明天";


        else if (ago <= ONE_MINUTE)
            return "刚刚";
        else if (ago <= ONE_HOUR)
            return ago / ONE_MINUTE + "分钟前";
        else if (ago <= ONE_DAY)
            return ago / ONE_HOUR + "小时" + (ago % ONE_HOUR / ONE_MINUTE)
                    + "分钟前";
        else if (ago <= ONE_DAY * 2)
            return "昨天" + calendar.get(Calendar.HOUR_OF_DAY) + "点"
                    ;// + calendar.get(Calendar.MINUTE) + "分";
        else if (ago <= ONE_DAY * 3)
            return "前天" + calendar.get(Calendar.HOUR_OF_DAY) + "点"
                    ;// + calendar.get(Calendar.MINUTE) + "分";
        else if (ago <= ONE_MONTH) {
            long day = ago / ONE_DAY;
            return day + "天前"
                    //+ calendar.get(Calendar.HOUR_OF_DAY) + "点"
                    ;//+ calendar.get(Calendar.MINUTE) + "分";
        } else if (ago <= ONE_YEAR) {
            long month = ago / ONE_MONTH;
            long day = ago % ONE_MONTH / ONE_DAY;
            return month + "个月前"// + day + "天前"
                  //  + calendar.get(Calendar.HOUR_OF_DAY) + "点"
                    ;// + calendar.get(Calendar.MINUTE) + "分";
        } else {
            long year = ago / ONE_YEAR;
            int month = calendar.get(Calendar.MONTH) + 1;// JANUARY which is 0 so month+1
            return year + "年前" //+ month + "月" + calendar.get(Calendar.DATE)
                   // + "日"
                    ;
        }

    }


    /**
     * 距离截止日期还有多长时间
     *
     * @param date
     * @return
     */
    public static String fromDeadline(Date date) {
        long deadline = date.getTime() / 1000;
        long now = (new Date().getTime()) / 1000;
        long remain = deadline - now;
        if (remain <= ONE_HOUR)
            return "只剩下" + remain / ONE_MINUTE + "分钟";
        else if (remain <= ONE_DAY)
            return "只剩下" + remain / ONE_HOUR + "小时"
                    + (remain % ONE_HOUR / ONE_MINUTE) + "分钟";
        else {
            long day = remain / ONE_DAY;
            long hour = remain % ONE_DAY / ONE_HOUR;
            long minute = remain % ONE_DAY % ONE_HOUR / ONE_MINUTE;
            return "只剩下" + day + "天" + hour + "小时" + minute + "分钟";
        }

    }

    /**
     * 距离今天的绝对时间
     *
     * @param date
     * @return
     */
    public static String toToday(Date date) {
        long time = date.getTime() / 1000;
        long now = (new Date().getTime()) / 1000;
        long ago = now - time;
        if (ago <= ONE_HOUR)
            return ago / ONE_MINUTE + "分钟";
        else if (ago <= ONE_DAY)
            return ago / ONE_HOUR + "小时" + (ago % ONE_HOUR / ONE_MINUTE) + "分钟";
        else if (ago <= ONE_DAY * 2)
            return "昨天" + (ago - ONE_DAY) / ONE_HOUR + "点" + (ago - ONE_DAY)
                    % ONE_HOUR / ONE_MINUTE + "分";
        else if (ago <= ONE_DAY * 3) {
            long hour = ago - ONE_DAY * 2;
            return "前天" + hour / ONE_HOUR + "点" + hour % ONE_HOUR / ONE_MINUTE
                    + "分";
        } else if (ago <= ONE_MONTH) {
            long day = ago / ONE_DAY;
            long hour = ago % ONE_DAY / ONE_HOUR;
            long minute = ago % ONE_DAY % ONE_HOUR / ONE_MINUTE;
            return day + "天前" + hour + "点" + minute + "分";
        } else if (ago <= ONE_YEAR) {
            long month = ago / ONE_MONTH;
            long day = ago % ONE_MONTH / ONE_DAY;
            long hour = ago % ONE_MONTH % ONE_DAY / ONE_HOUR;
            long minute = ago % ONE_MONTH % ONE_DAY % ONE_HOUR / ONE_MINUTE;
            return month + "个月" + day + "天" + hour + "点" + minute + "分前";
        } else {
            long year = ago / ONE_YEAR;
            long month = ago % ONE_YEAR / ONE_MONTH;
            long day = ago % ONE_YEAR % ONE_MONTH / ONE_DAY;
            return year + "年前" + month + "月" + day + "天";
        }

    }

    public static String getYear() {
        return calendar.get(Calendar.YEAR) + "";
    }

    public static String getMonth() {
        int month = calendar.get(Calendar.MONTH) + 1;
        return month + "";
    }

    public static String getDay() {
        return calendar.get(Calendar.DATE) + "";
    }

    public static String get24Hour() {
        return calendar.get(Calendar.HOUR_OF_DAY) + "";
    }

    public static String getMinute() {
        return calendar.get(Calendar.MINUTE) + "";
    }

    public static String getSecond() {
        return calendar.get(Calendar.SECOND) + "";
    }
    public String getTimeStamp(){   // 得到时间戳：yyyyMMddHHmmssSSS

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date()) ;
    }

    /**
     * @return yyyy-MM-dd HH:mm:ss
     * 2012-12-29 23:47:36
     */
    public static String getShortDate(Date date) {
        SimpleDateFormat simple = new SimpleDateFormat("MM-dd HH:mm");
        if(date != null) {
            return simple.format(date);
        }
        else {
            return "";
        }
    }

    /**
     * @return yyyy-MM-dd HH:mm:ss
     * 2012-12-29 23:47:36
     */
    public static String getMonthAndDay(Date date) {
        SimpleDateFormat simple = new SimpleDateFormat("MM-dd");
        if(date != null) {
            return simple.format(date);
        }
        else {
            return "";
        }
    }
    //获取周第一天
    public Date getStartDayOfWeek(String date) {
        LocalDate now = LocalDate.parse(date);
        return this.getStartDayOfWeek(now);
    }

    public Date getStartDayOfWeek(TemporalAccessor date) {
        TemporalField fieldISO = WeekFields.of(Locale.CHINA).dayOfWeek();
        LocalDate localDate = LocalDate.from(date);
        localDate.with(fieldISO, 1);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    //获取周最后一天
    public Date getEndDayOfWeek(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return this.getEndDayOfWeek(localDate);
    }

    public Date getEndDayOfWeek(TemporalAccessor date) {
        TemporalField fieldISO = WeekFields.of(Locale.CHINA).dayOfWeek();
        LocalDate localDate = LocalDate.from(date);
        localDate.with(fieldISO, 7);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).plusDays(1L).minusNanos(1L).toInstant());
    }
    //一天的开始
    public Date getStartOfDay(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return this.getStartOfDay(localDate);
    }

    public Date getStartOfDay(TemporalAccessor date) {
        LocalDate localDate = LocalDate.from(date);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date getStartOfDay(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    //一天的结束
    public Date getEndOfDay(String date){
        LocalDate localDate = LocalDate.parse(date);
        return this.getEndOfDay(localDate);
    }
    public static Date getEndOfDay(TemporalAccessor date) {
        LocalDate localDate = LocalDate.from(date);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).plusDays(1L).minusNanos(1L).toInstant());
    }

    long currTime = System.currentTimeMillis();



    //Calendar实例：

    private static Calendar mCalendar = Calendar.getInstance();


    public static String getFuture(Date date){
        Calendar today = Calendar.getInstance();
        Calendar old = Calendar.getInstance();
        old.setTime(date);
/*
        //此处的isEver everType startTime  createDate为pojo的属性
        if (("Y".equals(isEver) && everType == 2) || startTime == null) {
            old.setTime(createdDate);
        } else {
            old.setTime(startTime);
        }*/
        //此处好像是去除0
        today.set(Calendar.HOUR, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        old.set(Calendar.HOUR, 0);
        old.set(Calendar.MINUTE, 0);
        old.set(Calendar.SECOND, 0);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.println("today"+ format.format(today.getTimeInMillis()));
        System.out.println("old"+ format.format(old.getTimeInMillis()));


        //老的时间减去今天的时间
        long intervalMilli = old.getTimeInMillis() - today.getTimeInMillis();
        long days = ChronoUnit.DAYS.between(today.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(),old.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());

        System.out.println("Days between: " + days);


        if(days == 1){
            return "明天";
        }else if(days == 2){
            return "明天";
        }else if(days == 3){
            return "后天";
        }else if(days < 1) {
            return "过去";
        }else {
            return "将来";
        }

/*        System.out.println(intervalMilli);
        System.out.println( (24 * 60 * 60 * 1000));
        int xcts = (int) (intervalMilli / (24 * 60 * 60 * 1000));
        // -2:前天 -1：昨天 0：今天 1：明天 2：后天， out：显示日期
        if (xcts >= -2 && xcts <= 2) {
            return String.valueOf(xcts);
        } else {
            return "out";
        }*/
    }
    //获取昨天时间的最小值：
    public static long getYesterdayMinTimeMillis() {

        long currTime = System.currentTimeMillis();
        mCalendar.setTime(new Date(currTime));

        int year = mCalendar.get(Calendar.YEAR);
        int month = mCalendar.get(Calendar.MONTH);
        int day = mCalendar.get(Calendar.DAY_OF_MONTH);

        mCalendar.set(year, month, day, 0, 0, 0);
        long minToday = mCalendar.getTimeInMillis();// - mHourInMillis;

        return minToday;
    }

    //获取昨天时间的最大值：
    public static long getYesterdayMaxTimeMillis() {
        long currTime = System.currentTimeMillis();
        mCalendar.setTime(new Date(currTime));

        int year = mCalendar.get(Calendar.YEAR);
        int month = mCalendar.get(Calendar.MONTH);
        int day = mCalendar.get(Calendar.DAY_OF_MONTH);

        mCalendar.set(year, month, day, 23, 59, 59);
        long minToday = mCalendar.getTimeInMillis() ;//- mHourInMillis;

        return minToday;
    }



/*   // 判断某个时间是否是昨天：
    public static boolean isYesterday(long time) {
        if (itemCreatTime >= getYesterdayMinTimeMillis() &&
                itemCreatTime <= getYesterdayMaxTimeMillis()) {

            return true;
        } else {
            return false;
        }
    }*/

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date start  =null;
        try {
            start = format.parse("2016-05-04 00:11");// 开始日期
        } catch (ParseException e) {
            e.printStackTrace();
        }

         System.out.println(getFuture(start));


    }


    public static boolean isMoreThen(Date lastUseTime, int i) {


        Instant instant = LocalDateTime.now().minusMinutes(i).atZone(ZoneId.systemDefault()).toInstant();

        if(lastUseTime.before(Date.from(instant))){
            return true;
        }
        return  false;
    }

    public static String getDateAndHour(Date deliveryStartDate) {

        SimpleDateFormat simple = new SimpleDateFormat("yy/MM/dd HH");
        return simple.format(deliveryStartDate.getTime());
    }

    public static String getHourAndMinute(Date createDate) {
        SimpleDateFormat simple = new SimpleDateFormat("dd:HH");
        return simple.format(calendar.getTime());

    }

        public static void secondToHourAndMinutsAndSecent(String [] args){
            int h=123456/3600;
            int m=(123456%3600)/60;
            int s=(123456%3600)%60;
            System.out.println(h+"时"+m+"分"+s+"秒");
        }


    private static int days; //天数
    private static int hours; //时
    private static int minutes; //分
    private static int seconds; //秒

    //第一个字符串
    public static final String FIRST = "Sep 13 02:03:04 GMT 2012";

    //第二个字符串
    public static final String SECOND = "Aug 12 00:00:00 GMT 2012";
    public static void TimeDifference2 (Date firstDate,Date secondDate ) {

        //通过字符串创建两个日期对象
/*        Date firstDate = new Date(FIRST);
        Date secondDate = new Date(SECOND);*/

        //得到两个日期对象的总毫秒数
        long firstDateMilliSeconds = firstDate.getTime();
        long secondDateMilliSeconds = secondDate.getTime();

        //得到两者之差
        long firstMinusSecond = firstDateMilliSeconds - secondDateMilliSeconds;

        //毫秒转为秒
        long milliSeconds = firstMinusSecond;
        int totalSeconds = (int)(milliSeconds / 1000);

        //得到总天数
        days = totalSeconds / (3600*24);
        int days_remains = totalSeconds % (3600*24);

        //得到总小时数
        hours = days_remains / 3600;
        int remains_hours = days_remains % 3600;

        //得到分种数
        minutes = remains_hours / 60;

        //得到总秒数
        seconds = remains_hours % 60;

        //打印结果
        //第一个比第二个多32天2小时3分4秒
        System.out.print("第一个比第二个多");
        System.out.println(days+"天"+hours+"小时"+minutes+"分"+seconds+"秒");
    }
    public static String timeDifference3 (Integer seconds) {


        //得到两者之差
        long firstMinusSecond = seconds;

        //毫秒转为秒
        long milliSeconds = firstMinusSecond;
        int totalSeconds = (int)(milliSeconds / 1000);

        //得到总天数
        days = totalSeconds / (3600*24);
        int days_remains = totalSeconds % (3600*24);

        //得到总小时数
        hours = days_remains / 3600;
        int remains_hours = days_remains % 3600;

        //得到分种数
        minutes = remains_hours / 60;

        //得到总秒数
        seconds = remains_hours % 60;

        //打印结果
        //第一个比第二个多32天2小时3分4秒
        System.out.print("第一个比第二个多");
        return  days+"天"+hours+"小时"+minutes+"分"+seconds+"秒";
        //System.out.println(days+"天"+hours+"小时"+minutes+"分"+seconds+"秒");
    }

    public static String getFullDate(Date createDate) {
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simple.format(createDate);

    }


    public static String getFullDate_(Date createDate) {
        String startTime ="2016-11-13 23:59";
        String endtime = "2016-11-16 00:00";
        DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startLocalDate = LocalDateTime.parse(startTime, sf);
        LocalDateTime mid = startLocalDate.plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime mid1 = startLocalDate.plusDays(2).withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime mid2 = startLocalDate.plusDays(3).withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime endLocalDate = LocalDateTime.parse(endtime, sf);
        long sec =  ChronoUnit.SECONDS.between(startLocalDate, endLocalDate);
        long sec1 =  ChronoUnit.SECONDS.between(startLocalDate, mid);
        long sec2=  ChronoUnit.SECONDS.between(startLocalDate, mid1);
        long sec3 =  ChronoUnit.SECONDS.between(startLocalDate, mid2);
        if(sec<sec1){
            if(sec<60){
                System.out.println("刚刚");
            }else{
                System.out.println("今天"+startLocalDate.toString().substring(startLocalDate.toString().indexOf("T")+1));
            }
        }
        if(sec>=sec1 && sec<sec2){
            System.out.println("昨天"+startLocalDate.toString().substring(startLocalDate.toString().indexOf("T")+1));
        }
        if(sec>=sec2 && sec<sec3){
            System.out.println("前天"+startLocalDate.toString().substring(startLocalDate.toString().indexOf("T")+1));
        }
        if(sec>=sec3){
            System.out.println(startLocalDate.toString().replace("T", " "));
        }

        return null;
    }


    public static String getDate(Date date, SimpleDateFormat simpleDateFormat) {
      //  SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
       // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时MM分ss秒");

    }
}