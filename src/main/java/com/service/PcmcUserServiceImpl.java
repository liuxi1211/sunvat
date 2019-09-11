package com.service;

import com.dao.PcmcUserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.PcmcUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PcmcUserServiceImpl implements PcmcUserService{

    @Autowired
    private PcmcUserMapper pcmcUserMapper;

    @Override
    public List<PcmcUser> selectPcmcUserList(PcmcUser pcmcUser,int start,int end) {
        PageHelper.startPage(start,end);
        List<PcmcUser> pcmcUsers = pcmcUserMapper.selectPcmcUserList(pcmcUser);
        PageInfo pageInfo=new PageInfo(pcmcUsers);
        pageInfo.getTotal();
        pageInfo.getPageNum();

        return pcmcUsers;
    }
}
