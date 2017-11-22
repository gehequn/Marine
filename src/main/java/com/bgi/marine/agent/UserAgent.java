package com.bgi.marine.agent;

import com.bgi.marine.bean.vo.UserVo;

public interface UserAgent {

    UserVo loadUserById(int userId);

}
