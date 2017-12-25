package com.bgi.marine.agent;

import com.bgi.marine.bean.User;
import com.bgi.marine.bean.vo.UserVo;

import java.util.List;

public interface UserAgent {

    UserVo loadUserById(int userId);

    List<User> queryAll();

}
