package com.demo;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SytemTest {


    @Test
    public void getSystems() {
//        Properties properties = System.getProperties();
//        for(Object set:properties.keySet()){
//                String se=(String)set;
//            String property = properties.getProperty(se);
//            System.out.println(se+":"+property);
//        }
        String url = "jdbc:oracle:thin:@//localhost/orcl";
        String substring = url.substring(0, url.lastIndexOf("//")+2);
        System.out.println(substring);
    }
}
