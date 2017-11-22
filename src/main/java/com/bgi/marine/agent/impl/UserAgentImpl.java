package com.bgi.marine.agent.impl;

import com.bgi.marine.agent.UserAgent;
import com.bgi.marine.bean.vo.UserVo;
import com.bgi.marine.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAgentImpl implements UserAgent {

    @Resource
    private UserDao userDao;

    @Override
    public UserVo loadUserById(int userId) {
        return userDao.queryById(userId);
    }
}
