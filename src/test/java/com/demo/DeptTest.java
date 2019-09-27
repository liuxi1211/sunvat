package com.demo;

import com.service.DeptServiceImpl;
import com.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

public class DeptTest {
    private ClassPathXmlApplicationContext cpa;

    @Before
    public void beforTest(){
         cpa=new ClassPathXmlApplicationContext
                ("spring/spring-configs.xml");
    }

    @Test
    public void getDept() {
        DeptServiceImpl deptServiceImpl = cpa.getBean("deptServiceImpl", DeptServiceImpl.class);
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("stacid","1");
        hashMap.put("reptdp","M");
        String deptcd="009999";
        String deptSql = deptServiceImpl.getDeptSql(hashMap, deptcd);
        System.out.println("deptSql: "+deptSql);

    }
}
