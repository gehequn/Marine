package com.bgi.marine.agent.impl;

import com.bgi.marine.agent.RegisterAgent;
import com.bgi.marine.bean.User;
import com.bgi.marine.dao.UserDao;
import com.bgi.marine.dto.RegisterDto;
import com.bgi.marine.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisterAgentImpl implements RegisterAgent {

    @Resource
    private UserDao userDao;

    @Override
    public Long registerUser(RegisterDto registerDto) {
        User user = User.builder().build();
//        HashMap<String,String> map = new HashMap<>();
        CommonUtil.translate(registerDto,user,null);
        userDao.create(user);
        return user.getId();
    }
}