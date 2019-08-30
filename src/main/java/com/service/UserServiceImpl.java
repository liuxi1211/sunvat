package com.service;

import com.alibaba.fastjson.JSONObject;
import com.dao.UserDao;
import com.pojo.DistRelaBean;
import com.pojo.PcmcUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    private  Log log = LogFactory.getLog(UserService.class);
    @Autowired
    private UserDao userDao;
    List<String> listA=new ArrayList<>();
    List<String> listB=new ArrayList<>();
    public List<PcmcUser> queryUserNameList(){
        List<PcmcUser> pcmcUsers = userDao.queryUserNameList();
        return pcmcUsers;
    }

    public List<Map<String, String>>  getResultObjects(){
        List<String> aList=new ArrayList<>();
        List<String> list = userDao.queryListA();
        List<Map<String,String>> returnList=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            listA.clear();
            listB.clear();
            if (!aList.contains(list.get(i))){
                action(list.get(i),aList);
                Map<String,String> map = new HashMap<>();
                System.out.println(listA);
                System.out.println(listB);
                String strA = JSONObject.toJSONString(listA);
                String strB = JSONObject.toJSONString(listB);
                map.put("old",strA);
                map.put("new",strB);
                returnList.add(map);
            }
        }
        return returnList;
    }

    private void action(String string,List<String> aList){
        if (listA.contains(string)){
            return;
        }
        listA.add(string);
        aList.add(string);
      // List<String> list=new ArrayList<>();//查询旧科目对应的新科目
        List<String> list = userDao.queryListB(string);
        for(int i=0;i<list.size();i++){
           if(!listB.contains(list.get(i))){
               listB.add(list.get(i));
              // List<String> resultA=new ArrayList<>();//查询新科目对应的旧科目
               List<String> resultA = userDao.queryListA(list.get(i));
               for(int j=0;j<resultA.size();j++){
                   action(resultA.get(j),aList);
               }
           }

       }
    }



}
