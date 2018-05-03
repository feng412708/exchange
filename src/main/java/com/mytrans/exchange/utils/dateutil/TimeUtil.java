package com.mywind.windfarmplan.utils.dateutil;

import org.apache.commons.lang.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtil {
    public static Timestamp getNow() {
        return new Timestamp(System.currentTimeMillis());
    }


    /**
     * 算出今天是星期几
     * @return
     */
    public static int getTodayOfWeek() {
        LocalDate ld = LocalDate.now();
        DayOfWeek dayOfWeek = ld.getDayOfWeek();
        return dayOfWeek.getValue();
    }

    /**
     * 推算出明天、后天是星期几
     * @param futureDate  1代表明天，2代表后天，-1代表前天
     * @return  星期一到星期天用1-7表示
     */
    public static int getFutureWeekOfDateInt(int futureDate) {
        LocalDate ld = LocalDate.now();
        if (futureDate > 0) {
            ld.plusDays(futureDate);
        } else {
            ld.minusDays(futureDate);
        }

        return ld.getDayOfWeek().getValue();
    }

    /**
     * 推算出明天、后天是星期几
     * @param futureDate  1代表明天，2代表后天，-1代表前天
     * @return  LocalDate对象
     */
    public static LocalDate getFutureWeekOfDateLocalDate(int futureDate) {
        LocalDate ld = LocalDate.now();
        if (futureDate > 0) {
            ld = ld.plusDays(futureDate);
        } else {
            ld = ld.minusDays(futureDate);
        }

        return ld;
    }


    /**
     * Java8 新增的LocalDateTime，转换成传统的date
     * @param ldt
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime ldt) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = ldt.atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }


    /**
     * 使用：把LocalDateTime按照 年-月-日 时:分:秒 格式化日期，转换成字符串
     * 例子： 2017-09-12 22:11:25
     * @param ldt
     * @return
     */
    public static String localDateTimeToString(LocalDateTime ldt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ldt.format(formatter);
    }

    /**
     * 使用：把LocalDate按照 年-月-日 格式化日期，转换成字符串
     * 例子： 2017-09-12
     * @param ld
     * @return
     */
    public static String localDateToString(LocalDate ld) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return ld.format(formatter);
    }

    /***
     * get now time
     * @return Timestamp
     */
    @Deprecated
    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp getToday0Show(Timestamp time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dayStr = sdf.format(time);
        return Timestamp.valueOf(dayStr + " 00:00:00");
    }

    public static Timestamp getToday12Show(Timestamp time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dayStr = sdf.format(time);
        return Timestamp.valueOf(dayStr + " 12:00:00");
    }

    /**
     * 返回一个日期，只用来做显示
     *
     * @param nowDate
     * @return
     */
    public static Date getStringToDate(String nowDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return sdf.parse(nowDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 获得本周一的日期
    public static String getMondayOFWeek() {
        GregorianCalendar cal = new GregorianCalendar();
        Date now = new Date();
        cal.setTime(now);
        cal.setFirstDayOfWeek(GregorianCalendar.MONDAY); // 设置一个星期的第一天为星期1，默认是星期日
        cal.set(GregorianCalendar.DAY_OF_WEEK, GregorianCalendar.MONDAY);

        SimpleDateFormat dateutil = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        return dateutil.format(cal.getTime()).toString(); // 本周1
    }

    /**
     * 获取去年当月度的第一天 2017-01-01 00:00:00
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfLastYearMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set((cal.get(Calendar.YEAR) - 1), cal.get(Calendar.MONTH), 1, 0, 0, 0);

        return new Date(cal.getTime().getTime());
    }

    /**
     * 获取去年当月下月度的第一天 2017-01-01 00:00:00
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfLastYearNextMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set((cal.get(Calendar.YEAR) - 1), (cal.get(Calendar.MONTH) + 1), 1, 0, 0, 0);

        return new Date(cal.getTime().getTime());
    }

    /**
     * 获取当前年度的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfCurrYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set((cal.get(Calendar.YEAR)), 0, 1, 0, 0, 0);

        return new Date(cal.getTime().getTime());
    }

    /**
     * 获取下一年度的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfNextYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set((cal.get(Calendar.YEAR) + 1), 0, 1, 0, 0, 0);

        return new Date(cal.getTime().getTime());
    }

    /**
     * 获取上月度的第一天 2017-01-01 00:00:00
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfPreMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR), (cal.get(Calendar.MONTH) - 1), 1, 0, 0, 0);

        return new Date(cal.getTime().getTime());
    }


    /**
     * 获取当前月度的第一天 2017-01-01 00:00:00
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfCurrMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);

        return new Date(cal.getTime().getTime());
    }

    // 获取下月第一天
    public static Date getFirstDayOfNextMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR), (cal.get(Calendar.MONTH) + 1), 1, 0, 0, 0);

        return new Date(cal.getTime().getTime());
    }

    /**
     * 获取当前日期的月份的最后一天
     *
     * @param date 当前日期
     * @return 最后一天的时间点
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR), (cal.get(Calendar.MONTH) + 1), 1, 0, 0, 0);

        return new Date(cal.getTime().getTime() - 1000);
    }

    /**
     * 得到当前时间的前多少天
     */
    public static Timestamp getBeforeTime(int day) {
        Calendar objCal = Calendar.getInstance();
        objCal.add(Calendar.DATE, day);
        Timestamp date = new Timestamp(objCal.getTimeInMillis());
        return date;
    }


    public static Timestamp getAfterDayTime(Timestamp date, int day) {
        Calendar objCal = Calendar.getInstance();
        objCal.setTime(date);
        objCal.add(Calendar.DATE, day);
        return new Timestamp(objCal.getTimeInMillis());
    }

    public static Timestamp getZero() {
        return Timestamp.valueOf("1970-01-01 00:00:00");
    }

    // 获取今天开始时间
    public static String getToday() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

        return sdf.format(cal.getTime());
    }

    // 获取昨天开始时间
    public static String getyesToday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        return sf2.format(cal.getTime());
    }

    /**
     * 获取这个月的第一天起始位置
     *
     * @return Timestamp 比如：2012-05-01 00:00:00
     */
    public static Timestamp getMouthFirst() {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String dayStr = sdf.format(time);
        return Timestamp.valueOf(dayStr + "-01 00:00:00");
    }

    /**
     * 获取这天的开始时间
     *
     * @return Timestamp 比如：2012-05-01 13:00:00
     */
    public static Timestamp getTodayFirst() {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        return getTodayFirst(time);
    }

    /**
     * 获取这天的开始时间
     *
     * @return Timestamp 比如：2012-05-01 13:00:00
     */
    public static Timestamp getTodayFirst(Timestamp time) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dayStr = sdf.format(time);
        return Timestamp.valueOf(dayStr + " 00:00:00");
    }

    /**
     * 获取这天的开始时间
     *
     * @return Timestamp 比如：2012-05-01 13:00:00
     */
    public static Timestamp getTodayLast() {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        return getTodayLast(time);
    }

    /**
     * 获取这天的结束时间
     *
     * @return Timestamp 比如：2012-05-01 13:00:00
     */
    public static Timestamp getTodayLast(Timestamp time) {
        time = getAfterDayDate(time, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dayStr = sdf.format(time);
        return Timestamp.valueOf(dayStr + " 00:00:00");
    }

    public static String jsDate(Timestamp time) {

        SimpleDateFormat sdf = new SimpleDateFormat("MM dd,yyyy 00:mm:ss");
        return sdf.format(time);

    }

    /**
     * 获取这小时的开始时间
     *
     * @return Timestamp 比如：2012-05-01 13:00:00
     */
    public static Timestamp getHourFirst() {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        return getHourFirst(time);
    }

    /**
     * 获取这小时的开始时间
     *
     * @return Timestamp 比如：2012-05-01 13:00:00
     */
    public static Timestamp getHourFirst(Timestamp time) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        String dayStr = sdf.format(time);
        return Timestamp.valueOf(dayStr + ":00:00");
    }

    /**
     * 获取这小时的开始时间
     *
     * @return Timestamp 比如：2012-05-01 13:00:00
     */
    public static Timestamp getHourLast() {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        return getHourLast(time);
    }

    /**
     * 获取这小时的开始时间
     *
     * @return Timestamp 比如：2012-05-01 13:00:00
     */
    public static Timestamp getHourLast(Timestamp time) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        String dayStr = sdf.format(time);
        return Timestamp.valueOf(dayStr + ":59:00");
    }

    /**
     * 获取这分钟的开始时间
     *
     * @return Timestamp 比如：2012-05-01 13:21:00
     */
    public static Timestamp getMinuteFirst() {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dayStr = sdf.format(time);
        return Timestamp.valueOf(dayStr + ":00");
    }

    /**
     * 获取这分钟的开始时间
     *
     * @return Timestamp 比如：2012-05-01 13:21:00
     */
    public static Timestamp getMinuteFirst(long times) {
        Timestamp time = new Timestamp(times);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dayStr = sdf.format(time);

        return Timestamp.valueOf(dayStr + ":00");
    }

    /**
     * 获取0-1440的一个分钟数
     *
     * @return Timestamp 比如：2012-05-01 13:21:00
     */
    public static int getMinuteFirstInDay(long times) {
        Timestamp time = new Timestamp(times);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String dayStr = sdf.format(time);
        String sp[] = dayStr.split(":");
        return Integer.parseInt(sp[0]) * 60 + Integer.parseInt(sp[1]);
    }

    /**
     * 获取0-1440*60的一个秒数，在一天当中的秒数
     *
     * @return Timestamp 比如：2012-05-01 13:21:00
     */
    public static int getSecondInDay(long times) {
        Timestamp time = new Timestamp(times);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String dayStr = sdf.format(time);
        String sp[] = dayStr.split(":");
        return Integer.parseInt(sp[0]) * 60 * 60 + Integer.parseInt(sp[1]) * 60 + Integer.parseInt(sp[2]);
    }

    /**
     * 获取与2013年1月1日之间的天数差
     *
     * @return Timestamp 比如：2012-05-01 13:21:00
     */
    public static long getDayInYear(long times) {
        try {
            Timestamp time = new Timestamp(times);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            String date2 = "2013-01-01";
            Date d2 = sdf.parse(date2);

            long daysBetween = (time.getTime() - d2.getTime() + 1000000) / (3600 * 24 * 1000);

            return daysBetween;

        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public static Timestamp getAfterSecDate(Timestamp date, int second) {
        Calendar objCal = Calendar.getInstance();
        objCal.setTime(date);
        objCal.add(13, second);
        Timestamp ndate = new Timestamp(objCal.getTimeInMillis());
        return ndate;
    }

    /**
     * 得到当前时间的后n天
     * 可以传递负值
     */
    public static Timestamp getAfterDayTime(Date d, int n) {
        Calendar objCal = Calendar.getInstance();
        objCal.setTime(d);
        objCal.add(Calendar.DATE, n);
        Timestamp date = new Timestamp(objCal.getTimeInMillis());
        return date;
    }

    public static Timestamp getAfterDayDate(Timestamp date, int day) {
        Calendar objCal = Calendar.getInstance();
        objCal.setTime(date);
        objCal.add(5, day);
        Timestamp ndate = new Timestamp(objCal.getTimeInMillis());
        return ndate;
    }

    public static Timestamp getAfterWeekDate(Timestamp date, int day) {
        Calendar objCal = Calendar.getInstance();
        objCal.setTime(date);
        objCal.add(4, day);
        Timestamp ndate = new Timestamp(objCal.getTimeInMillis());
        return ndate;
    }

    public static Timestamp getAfterMonthDate(Timestamp date, int day) {
        Calendar objCal = Calendar.getInstance();
        objCal.setTime(date);
        objCal.add(2, day);
        Timestamp ndate = new Timestamp(objCal.getTimeInMillis());
        return ndate;
    }

    /***
     * before 到 to 还差的  天 时 分 秒
     * @param before
     * @param to
     * @return
     */
    public static String getDhms(Timestamp before, Timestamp to) {
        long total_time = to.getTime() - before.getTime();
        return getShowByCha(total_time);
    }

    public static String getShowByCha(long cha) {

        long day = cha / (24 * 60 * 60 * 1000);
        long hour = (cha / (60 * 60 * 1000) - day * 24);
        long min = ((cha / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (cha / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

        String strHour = hour < 10 ? ("0" + hour).toString() : String.valueOf(hour);
        String strMin = min < 10 ? ("0" + min).toString() : String.valueOf(min);
        String strS = s < 10 ? ("0" + s).toString() : String.valueOf(s);

        if (cha < 0) {
            return null;
        }

        return "" + day + "天" + strHour + "小时" + strMin + "分" + strS + "秒";
    }

    public static int getDiffDay(Timestamp endTime, Timestamp startTime) {
        double intervalMilli = endTime.getTime() - startTime.getTime();

        double d = (intervalMilli / (24 * 60 * 60 * 1000));

        int id = (int) d;

        if (d > id) {
            id = id + 1;
        }
        return id;
    }

    public static String getDifferenceTime(Date date) {
        if (date == null)
            return null;

        Date currentDate = new Date();
        long total_time = currentDate.getTime() - date.getTime();
        // 计算出相差天数
        long days = total_time / (24 * 3600 * 1000);
        // 计算出小时数
        long leave1 = total_time % (24 * 3600 * 1000); // 计算天数后剩余的毫秒数
        long hours = leave1 / (3600 * 1000);
        // 计算相差分钟数
        long leave2 = leave1 % (3600 * 1000); // 计算小时数后剩余的毫秒数
        long minutes = leave2 / (60 * 1000);
        // 计算相差秒数
        long leave3 = leave2 % (60 * 1000); // 计算分钟数后剩余的毫秒数
        long seconds = leave3 / 1000;

        if (days > 0) {
            if (days > 2) {
                return getDateToString(date);
            } else {
                String hm = new SimpleDateFormat("HH:mm").format(date);
                return days == 1 ? "昨天 " + hm : days == 2 ? "前天 " + hm : days + " 天 " + hm;
            }
        } else if (hours > 0) {
            return hours + " 小时前";
        } else if (minutes > 0) {
            return minutes + " 分钟前";
        } else if (seconds > 0) {
            return seconds + " 秒前";
        }
        return null;
    }

    /**
     * 把Date对象转换成String
     * 格式："yyyy-MM-dd HH:mm"
     * @param date
     * @return
     */
    public static String getDateToString(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 把Date对象转换成String
     * 格式："yyyy-MM-dd HH:mm:ss"
     * @param date
     * @return
     */
    public static String parseDateToString(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getIntervalDays(Timestamp startday, Timestamp endday) {
        //分别得到两个时间的毫秒数
        long sl = startday.getTime();
        long el = endday.getTime();
        long ei = el - sl;
        //根据毫秒数计算间隔天数
        return (int) (ei / (1000 * 60 * 60 * 24));
    }

    public static Timestamp getAfterDay(int days) {
        long oneday = 24 * 60 * 60 * 1000;
        return new Timestamp(System.currentTimeMillis() + oneday * days);
    }

    public static String parseDate(long dateTime) {
        Date date = new Date();
        date.setTime(dateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static long parseDate(String dateTime) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(dateTime).getTime();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static Timestamp getAfterDate(int second) {
        Calendar objCal = Calendar.getInstance();
        objCal.setTime(getNow());
        objCal.add(Calendar.SECOND, second);
        Timestamp ndate = new Timestamp(objCal.getTimeInMillis());
        return ndate;
    }

    public static Timestamp getAfterHour(int hour) {
        Calendar objCal = Calendar.getInstance();
        objCal.setTime(getNow());
        objCal.add(Calendar.HOUR_OF_DAY, hour);
        Timestamp ndate = new Timestamp(objCal.getTimeInMillis());
        return ndate;
    }

    /**
     * 获取上个月第一天
     *
     * @return
     */
    public static String getLastMonthFirstDay() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)) + "-01 00:00:00";
    }

    /*****
     *
     * @param srcTime  原始时间
     * @param cha     相差时间    1天  或者一个月  或者一年  一小时均可
     * @param unit    对应cha中的单位  天月年    如：Calendar.MONTH
     * @return
     */
    public static Timestamp getTimeByCha(Timestamp srcTime, int cha, int unit) {

        Calendar objCal = Calendar.getInstance();
        objCal.setTime(srcTime);
        objCal.add(unit, cha);
        Timestamp date = new Timestamp(objCal.getTimeInMillis());
        return date;
    }

    /**
     * 获取上个月最后一天
     *
     * @return
     */
    public static String getLastMonthLastDay() {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH) + " 23:59:59";
    }

    public static long getDhmsMillByIntevalday(int Intevalday, Date date) {

        /** 有效支付时间 */
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, Intevalday);

        date = calendar.getTime();
        Date currentDate = new Date();
        long cha = date.getTime() - currentDate.getTime();

        return cha;
    }

    public static Timestamp getAm10(Timestamp time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);

        cal.set(Calendar.HOUR_OF_DAY, 10);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return new Timestamp(cal.getTimeInMillis());
    }

    /***
     * 获取当前日期与 指定日期 后 day 天后 的时间差值 字符串
     *
     * @param Intevalday
     * @param date
     * @return
     */
    public static String getDhmsByIntevalday(int Intevalday, Date date) {
        long cha = getDhmsMillByIntevalday(Intevalday, date);
        return getShowByCha(cha);
    }

    /**
     * 此方法可获取当前时间的分钟数，从00：00为1开始，一直到23：59为1440结束。
     * 所以每天的取值范围是0-1440
     */
    public static int getMins() {
        Timestamp todayFirst = TimeUtil.getTodayFirst();
        long todayMins = TimeUtil.getNow().getTime() - todayFirst.getTime();
        return ((int) (todayMins / 60000) + 1);
    }

    /**
     * 此方法可获取当前时间的分钟数，从00：00为1开始，一直到23：59为1440结束。
     * 所以每天的取值范围是0-1440
     */
    public static int getMins(long now) {
        Timestamp todayFirst = TimeUtil.getTodayFirst();
        long todayMins = now - todayFirst.getTime();
        return ((int) (todayMins / 60000) + 1);
    }

    /**
     * 是否是今天
     *
     * @param date
     * @return
     */
    public static boolean isToday(final Date date) {
        return isTheDay(date, new Date());
    }

    /**
     * 是否是指定日期
     *
     * @param date
     * @param day
     * @return
     */
    public static boolean isTheDay(final Date date, final Date day) {
        return date.getTime() >= dayBegin(day).getTime()
                && date.getTime() <= dayEnd(day).getTime();
    }

    /**
     * 获取指定时间的那天 00:00:00.000 的时间
     *
     * @param date
     * @return
     */
    public static Date dayBegin(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获取指定时间的下一天的  00:00:00.000 的时间
     *
     * @param date
     * @return
     */
    public static Date nextDayBegin(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) + 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获取指定时间的那天 23:59:59.999 的时间
     *
     * @param date
     * @return
     */
    public static Date dayEnd(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    /**
     * 获取上月度的当天 2017-01-01 00:00:00
     *
     * @param date 当前日期
     * @return
     */
    public static Date getCurrDayOfPreMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR), (cal.get(Calendar.MONTH) - 1), cal.get(Calendar.DATE));

        return new Date(cal.getTime().getTime());
    }

    /**
     * 获取去年当天
     *
     * @param date
     * @return
     */
    public static Date getCurrDayOfPreYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set((cal.get(Calendar.YEAR) - 1), (cal.get(Calendar.MONTH)), cal.get(Calendar.DATE));

        return new Date(cal.getTime().getTime());
    }

    /**
     * 返回当前日期所在月份的总天数
     *
     * @param date 当前日期
     * @return
     */
    public static int getDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.getActualMaximum(Calendar.DATE);
        return day;
    }

    public static void main(String[] args) {
//		Timestamp ts = Timestamp.valueOf("2013-11-18 00:00:00");
//		System.out.println(getAfterDayDate(ts, -1));
//		
//		System.out.println(getAfterDate(60));
//		System.out.println(getTodayFirst());
//		System.out.println(getLastMonthLastDay());
    /*	Timestamp yesterday = Timestamp.valueOf(getyesToday());
		System.out.println( isTheDay(Timestamp.valueOf("2016-01-09 09:00:00"), yesterday) );

		Calendar cal = Calendar.getInstance();
	//	cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR),(11 +3),1,0,0,0);
*/

        System.out.println(DateFormatUtils.format(getCurrDayOfPreYear(new Date()), "yyyy-MM-dd HH:mm:ss"));

    }

}