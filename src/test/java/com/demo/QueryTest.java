package com.demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QueryTest {
    private ClassPathXmlApplicationContext ac;
    @Before
    public void beforTest(){
        //加载核心配置文件
         ac=new ClassPathXmlApplicationContext("spring/spring-configs.xml");
        //获取bean
        ac.getBean("");

    }
    @Test
    public void process(){


    }

}
