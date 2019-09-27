package com.dao;

import com.pojo.DistRelaBean;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface DeptDao {
    List<DistRelaBean> getDeptListByType(HashMap<String,String> hashMap);
    int queryTxaVchr(@Param("begin") String begin,@Param("end") String end);
    void insertOdsglbalanceint(String bsnsdt);
    void insertOdsgljournalint(String bsnsdt);
}
