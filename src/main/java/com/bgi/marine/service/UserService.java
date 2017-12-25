package com.bgi.marine.service;

import com.bgi.marine.bean.vo.UserVo;

import java.util.List;

public interface UserService {
    UserVo getUserInfo(int userId);

    List<UserVo> getUserList();
}
