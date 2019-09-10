package com.dao;

import com.pojo.GliVchr;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Param;

public interface GliVchrMapper {
    int deleteByPrimaryKey(@Param("stacid") BigDecimal stacid, @Param("systid") String systid, @Param("trandt") String trandt, @Param("transq") String transq, @Param("vchrsq") String vchrsq);

    int insert(GliVchr record);

    int insertSelective(GliVchr record);

    GliVchr selectByPrimaryKey(@Param("stacid") BigDecimal stacid, @Param("systid") String systid, @Param("trandt") String trandt, @Param("transq") String transq, @Param("vchrsq") String vchrsq);

    int updateByPrimaryKeySelective(GliVchr record);

    int updateByPrimaryKey(GliVchr record);
}