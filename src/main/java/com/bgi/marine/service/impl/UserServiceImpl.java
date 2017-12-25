package com.bgi.marine.service.impl;

import com.bgi.marine.agent.UserAgent;
import com.bgi.marine.bean.vo.UserVo;
import com.bgi.marine.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserAgent userAgent;

    @Override
    public UserVo getUserInfo(int userId) {
        return userAgent.loadUserById(userId);
    }

    @Override
    public List<UserVo> getUserList() {
        List<UserVo> userVoList = new ArrayList<>();
        userAgent.queryAll().forEach(user -> {
            userVoList.add(UserVo.builder()
                    .id(new Long(user.getId()).intValue())
                    .userName(user.getUserName())
                    .nickName(user.getUserName())
                    .emailAddress(user.getEmailAddress())
                    .mobile(user.getMobile())
                    .build());
        });
        return userVoList;
    }
}
