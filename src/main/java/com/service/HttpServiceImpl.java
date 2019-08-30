package com.service;

import com.util.HttpClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HttpServiceImpl implements HttpService{


    public String sendHttpClient(){
        HttpClient httpClient=new HttpClient();
        String url="";
        Map<String,String> map = new HashMap<String,String>();
       String param="";

        map.put("param",param);
        String result=null;
        try {
            result=httpClient.doGet("http://200.100.51.66:7902/InsertOaInvoice.do",map);
        }catch (Exception e){
        }

        return result;
    }
}
