package com.bgi.marine.service.impl;

import com.bgi.marine.agent.UserAgent;
import com.bgi.marine.bean.vo.UserVo;
import com.bgi.marine.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserAgent userAgent;

    @Override
    public UserVo getUserInfo(int userId) {
        return userAgent.loadUserById(userId);
    }
}
