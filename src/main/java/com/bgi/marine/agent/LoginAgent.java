package com.bgi.marine.agent;

import com.bgi.marine.bean.vo.UserVo;

/**
 * Created by GeHeQun on 2017/5/12.
 */
public interface LoginAgent {
    UserVo queryByName(String userName);
    int queryUserByName(String userName);
}
