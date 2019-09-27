package com.demo;

import com.dao.DeptDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TxaVchrTest {
    private ApplicationContext ctx ;
    @Before
    public void before(){
         ctx=new ClassPathXmlApplicationContext("spring/spring-configs.xml");
    }
    @Test
    public void TxaTest(){
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
        DeptDao mapper = sqlSessionFactory.openSession().getMapper(DeptDao.class);
        String begin="20151012";
        String end ="20151014";
        int i = mapper.queryTxaVchr(begin,end);
        mapper.insertOdsglbalanceint("20190630");
        mapper.insertOdsgljournalint("20190630");
        System.out.println(i);
    }

}
