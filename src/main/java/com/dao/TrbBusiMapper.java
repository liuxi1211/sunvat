package com.dao;

import com.pojo.TrbBusi;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrbBusiMapper {
    int deleteByPrimaryKey(@Param("stacid") Integer stacid, @Param("systid") String systid, @Param("trandt") String trandt, @Param("transq") String transq, @Param("vchrsq") String vchrsq);

    int insert(TrbBusi record);

    int insertSelective(TrbBusi record);

    TrbBusi selectByPrimaryKey(@Param("stacid") Integer stacid, @Param("systid") String systid, @Param("trandt") String trandt, @Param("transq") String transq, @Param("vchrsq") String vchrsq);

    List<TrbBusi> selectTrbBusiList(TrbBusi trbBusi);

    int updateByPrimaryKeySelective(TrbBusi record);

    int updateByPrimaryKey(TrbBusi record);
}