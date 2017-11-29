package com.bgi.marine.agent.impl;

import com.bgi.marine.agent.LoginAgent;
import com.bgi.marine.bean.vo.UserVo;
import com.bgi.marine.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginAgentImpl implements LoginAgent {

    @Resource
    private UserDao userDao;

    @Override
    public UserVo queryByName(String userName) {
        return userDao.queryByName(userName);
    }

    @Override
    public int queryUserByName(String userName) {
        return userDao.queryUserByName(userName);
    }

}
