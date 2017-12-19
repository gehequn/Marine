package com.bgi.marine.service.impl;

import com.bgi.marine.agent.LoginAgent;
import com.bgi.marine.bean.common.ResponseMap;
import com.bgi.marine.bean.vo.Privilege;
import com.bgi.marine.bean.vo.UserVo;
import com.bgi.marine.constants.Constants;
import com.bgi.marine.constants.LoginConstants;
import com.bgi.marine.dto.LoginDto;
import com.bgi.marine.service.LoginService;
import com.bgi.marine.service.PrivilegeService;
import com.bgi.marine.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginAgent loginAgent;

    @Resource
    private PrivilegeService privilegeService;

    @Override
    public ResponseMap login(LoginDto loginDto, HttpSession session) {

        ResponseMap responseMap = ResponseMap.builder().build();
        if (loginAgent.queryUserByName(loginDto.getUserName()) == 0) {
            responseMap.setFlag(LoginConstants.EMPTY_USER_NAME_FLAG);
            responseMap.setMessage(LoginConstants.EMPTY_USER_NAME);
            return responseMap;
        }
        UserVo userVo = loginAgent.queryByName(loginDto.getUserName());
        if (!MD5Util.encode2hex(loginDto.getPassword()).equals(userVo.getPassword())) {
            responseMap.setFlag(LoginConstants.WRONG_PASSWORD_FLAG);
            responseMap.setMessage(LoginConstants.WRONG_PASSWORD);
            return responseMap;
        }
        session.setAttribute(LoginConstants.USER_ID, userVo.getId());
        session.setAttribute(LoginConstants.USER_NAME, userVo.getUserName());
        session.setAttribute(LoginConstants.USER_TYPE, userVo.getUserType());
        //加载用户菜单权限
        Privilege privilege  = privilegeService.loadUserMenu(userVo.getUserType(), userVo.getId());
        session.setAttribute(LoginConstants.USER_PRIVILEGE, privilege);
        //todo 加载用户功能权限
        responseMap.setFlag(Constants.SUCCESS_FLAG);
        return responseMap;
    }
}
