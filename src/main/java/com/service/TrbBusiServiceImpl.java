package com.service;

import com.dao.TrbBusiMapper;
import com.pojo.TrbBusi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrbBusiServiceImpl implements TrbBusiService{
    @Autowired
    private TrbBusiMapper trbBusiMapper;

    @Override
    public List<TrbBusi> selectTrbBusiList(TrbBusi trbBusi) {
        List<TrbBusi> trbBusis = trbBusiMapper.selectTrbBusiList(trbBusi);
        return trbBusis;
    }
}
