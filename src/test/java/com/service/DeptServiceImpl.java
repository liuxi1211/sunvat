package com.service;

import com.dao.DeptDao;
import com.dao.UserDao;
import com.pojo.DistRelaBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class DeptServiceImpl implements  DeptService{
    private Log log = LogFactory.getLog(UserService.class);
    @Autowired
    private DeptDao deptDao;

    public String getDeptSql(HashMap<String,String> hashMap, String deptcd){
        List<DistRelaBean> deptListByType = deptDao.getDeptListByType(hashMap);
        StringBuffer result=new StringBuffer();
        return getParentDept(deptListByType,deptcd,true,result,0);
    }

    public String getParentDept(List<DistRelaBean> distList,
                                String deptcd, boolean isFirst, StringBuffer result, int count) {
        result.append("'" + deptcd + "'");
        if (!isFirst) return result.toString();
        //第二级
        for (int m = 0; m < distList.size(); m++) {
            DistRelaBean dept = distList.get(m);
            String sprrdp = dept.getSprrdp();
            if (deptcd.equals(sprrdp)) {
                result.append(",'" + dept.getDeptcd() + "'");
                //第三级
                for (int n = 0; n < distList.size(); n++) {
                    DistRelaBean dept1 = distList.get(n);
                    if (dept.getDeptcd().equals(dept1.getSprrdp())) {
                        result.append(",'" + dept1.getDeptcd() + "'");
                        //第四级
                        for (int i = 0; i < distList.size(); i++) {
                            DistRelaBean dept2 = distList.get(i);
                            if (dept1.getDeptcd().equals(dept2.getSprrdp())) {
                                result.append(",'" + dept2.getDeptcd() + "'");
                                //第五级
                                for (int j = 0; j < distList.size(); j++) {
                                    DistRelaBean dept3 = distList.get(j);
                                    if (dept2.getDeptcd().equals(dept3.getSprrdp())) {
                                        result.append(",'" + dept3.getDeptcd() + "'");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result.toString();
    }
}
