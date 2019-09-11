package com.dao;

import com.pojo.PcmcUser;
import java.math.BigDecimal;
import java.util.List;

public interface PcmcUserMapper {
    int deleteByPrimaryKey(BigDecimal userid);

    int insert(PcmcUser record);

    int insertSelective(PcmcUser record);

    PcmcUser selectByPrimaryKey(BigDecimal userid);

    int updateByPrimaryKeySelective(PcmcUser record);

    int updateByPrimaryKey(PcmcUser record);

    List<PcmcUser> selectPcmcUserList(PcmcUser pcmcUser);
}