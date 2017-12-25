package com.bgi.marine.agent.impl;

import com.bgi.marine.agent.UserAgent;
import com.bgi.marine.bean.User;
import com.bgi.marine.bean.vo.UserVo;
import com.bgi.marine.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserAgentImpl implements UserAgent {

    @Resource
    private UserDao userDao;

    @Override
    public UserVo loadUserById(int userId) {
        return userDao.queryById(userId);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }
}
