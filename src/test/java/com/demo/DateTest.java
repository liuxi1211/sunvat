package com.demo;

import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String bsnsdt ="20190601";
    @Test
    public void getDate1() throws  Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date parse = sdf.parse(bsnsdt);
        Calendar instance = Calendar.getInstance();
        instance.setTime(parse);
        instance.set(Calendar.DAY_OF_MONTH, 1);
        instance.add(Calendar.DAY_OF_MONTH, -1);
        String enddate = sdf.format(instance.getTime());//上个月月末
        instance.set(Calendar.DAY_OF_MONTH, 1);
        String startdate = sdf.format(instance.getTime());//上个月月初
        String period = enddate.substring(0, enddate.length() - 2);//日期转换成总账期间
        StringBuilder stringBuilder=new StringBuilder(period);
        StringBuilder insert = stringBuilder.insert(4, "-");
        period=insert.toString();
        System.out.println(startdate+"_"+enddate+"_"+period);
    }


    @Test
    public void getDate2() throws Exception{
        StringBuilder sd = new StringBuilder(bsnsdt);
        sd.insert(4, "-");
        sd.insert(7, "-");
        String sysdate = sd.toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(sysdate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1); // 设置为账套时间
        calendar.set(Calendar.DAY_OF_MONTH, 1); // 设置为当月第一天
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        date1 = calendar.getTime();
        String date = sdf.format(date1);
        String startdate = getMinMonthDate(date).replace("-", "");//转换格式之后的月初日期
        String enddate = getMaxMonthDate(date).replace("-", "");//转换格式之后的月末日期
        String period = date.substring(0,date.length()-3);//日期转换成总账期间
        System.out.println(startdate+"_"+enddate+"_"+period);
    }
    public static String getMinMonthDate(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(date));
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return dateFormat.format(calendar.getTime());
    }

    public static String getMaxMonthDate(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(date));
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dateFormat.format(calendar.getTime());
    }

}
