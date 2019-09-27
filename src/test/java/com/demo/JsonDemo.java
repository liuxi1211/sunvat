package com.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.logging.XMLFormatter;

public class JsonDemo {

    @Test
    public void jsonTest() throws  Exception{
        String json="{\"data_row\":[{\"deptlevel\":1,\"createtime\":\"2019-09-04 21:44:41\",\"deptdes\":\"\"," +
                "\"deptmiddlepicurl\":\"\",\"deptcode\":5199,\"ordernum\":0,\"deptsmallpicurl\":\"\",\"parentid\":0," +
                "\"deptname\":\"知名创伤外科\",\"inputcode\":\"zmcswk\",\"hospitalid\":\"H0001\"," +
                "\"hospitalname\":\"同济主院区\",\"location\":\"门诊十楼\",\"deptbigpicurl\":\"\",\"lastmodify\":\"2019-09-09 " +
                "01:00:02\"}]}";

        JSONObject jsonObject = JSON.parseObject(json);
        JSONArray data_row = jsonObject.getJSONArray("data_row");
        List<HashMap> hashMaps = JSON.parseArray(data_row.toJSONString(), HashMap.class);
        System.out.println(hashMaps.toString());
    }
}
