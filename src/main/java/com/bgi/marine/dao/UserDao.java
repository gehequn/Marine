package com.bgi.marine.dao;

import com.bgi.marine.bean.User;
import com.bgi.marine.bean.vo.UserVo;
import com.bgi.marine.dao.common.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends BaseDao<User> {

    int queryUserByName(@Param("userName") String userName);

    int queryUserByEmailAddress(@Param("emailAddress") String emailAddress);

    UserVo queryByName(@Param("userName") String userName);

    UserVo queryById(@Param("userId") int userId);

    List<User> queryAll();
}
