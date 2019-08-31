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
    //有一个美丽的小女孩
    public List<String> queryListb(String nameA);
    public List<String> queryListd(String nameA);
    public List<String> queryList11(String nameA);
    public List<String> queryList22(String nameA);
    public List<String> queryList33(String nameA);
    public List<String> queryList2ddd(String nameA);
    public List<String> queryList6ddd(String nameA);
    public List<String> queryList6dddaa(String nameA);
    List<DistRelaBean> getDeptListByType(HashMap<String,String> hashMap);
}
