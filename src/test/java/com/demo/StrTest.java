package com.demo;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StrTest {



    @Test
    public void demo1(){
        String bsnsdt="20191231";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Date parse = null;
        try {
            parse = sdf.parse(bsnsdt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(parse);
        instance.add(Calendar.DAY_OF_MONTH,1);
        System.out.println(sdf.format(instance.getTime()));



        String oldBsnsdt="20191231";
        Calendar c = Calendar.getInstance();
        int year = Integer.valueOf(oldBsnsdt.substring(0, 4));//2019
        int month = Integer.valueOf(oldBsnsdt.substring(4, 6)) - 1;//11
        int day = Integer.valueOf(oldBsnsdt.substring(6, 8)) + 1;//32
        c.set(year, month, day);
        Date date = c.getTime();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
        String newBsnsdt = dateformat.format(date);
        System.out.println(newBsnsdt);

    }
}
