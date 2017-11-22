package com.bgi.marine.service.impl;

import com.bgi.marine.agent.LoginAgent;
import com.bgi.marine.bean.common.ResponseMap;
import com.bgi.marine.bean.vo.UserVo;
import com.bgi.marine.constants.Constants;
import com.bgi.marine.constants.LoginConstants;
import com.bgi.marine.dto.LoginDto;
import com.bgi.marine.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginAgent loginAgent;

    @Override
    public ResponseMap login(LoginDto loginDto, HttpSession session) {

        ResponseMap responseMap = ResponseMap.builder().build();
        if (loginAgent.queryUserByName(loginDto.getUserName()) == 0){
            responseMap.setFlag(LoginConstants.EMPTY_USER_NAME_FLAG);
            responseMap.setMessage(LoginConstants.EMPTY_USER_NAME);
            return responseMap;
        }
        UserVo userVo =  loginAgent.queryByName(loginDto.getUserName());
        //todo 密码md5加密
        if (!userVo.getPassword().equals(loginDto.getPassword())){
            responseMap.setFlag(LoginConstants.WRONG_PASSWORD_FLAG);
            responseMap.setMessage(LoginConstants.WRONG_PASSWORD);
            return responseMap;
        }
        session.setAttribute("userId",userVo.getId());
        session.setAttribute("userName",userVo.getUserName());
        responseMap.setFlag(Constants.SUCCESS_FLAG);
        return responseMap;
    }
}
