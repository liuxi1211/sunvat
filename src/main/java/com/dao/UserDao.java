package com.dao;

import com.pojo.DistRelaBean;
import com.pojo.PcmcUser;

import java.util.HashMap;
import java.util.List;

public interface UserDao {
    public List<PcmcUser> queryUserNameList();
    public List<String> queryListA(String nameB);
    public List<String> queryListA();
    public List<String> queryListB(String nameA);
    List<DistRelaBean> getDeptListByType(HashMap<String,String> hashMap);
}
