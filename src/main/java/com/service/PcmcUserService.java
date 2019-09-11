package com.service;

import com.pojo.PcmcUser;

import java.util.List;

public interface PcmcUserService {
    List<PcmcUser> selectPcmcUserList(PcmcUser pcmcUser,int start,int end);
}
