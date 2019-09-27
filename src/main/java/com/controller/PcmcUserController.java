package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.Page;
import com.pojo.PcmcUser;
import com.service.HttpService;
import com.service.HttpServiceImpl;
import com.service.PcmcUserService;
import com.service.UserServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.util.HttpClient;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller()
public class PcmcUserController {
    private   Log log= LogFactory.getLog(PcmcUserController.class);
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private PcmcUserService pcmcUserService;

    @RequestMapping("demo")
    @ResponseBody
    public List<PcmcUser> queryUserNameList(){
        log.debug("进入controller方法");
        List<PcmcUser> pcmcUsers = userServiceImpl.queryUserNameList();
        return pcmcUsers;
    }
    @ResponseBody
    @RequestMapping("hahaha")
    public String getHttpClient(){
        List<Map<String, String>> resultObjects = userServiceImpl.getResultObjects();
        return JSONObject.toJSONString(resultObjects);
    }

    @ResponseBody
    @RequestMapping("list")
    public List<PcmcUser> queryPcmcUserList(int start,int end){
        PcmcUser pcmcUser=new PcmcUser();
        List<PcmcUser> pcmcUsers = pcmcUserService.selectPcmcUserList(pcmcUser,start,end);
        return  pcmcUsers;
    }
}
