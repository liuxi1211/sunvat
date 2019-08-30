package com.dao;

import com.pojo.DistRelaBean;

import java.util.HashMap;
import java.util.List;

public interface DeptDao {
    List<DistRelaBean> getDeptListByType(HashMap<String,String> hashMap);
}
