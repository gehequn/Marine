package com.bgi.marine.service.impl;

import com.bgi.marine.agent.RegisterAgent;
import com.bgi.marine.bean.common.ResponseMap;
import com.bgi.marine.constants.Constants;
import com.bgi.marine.constants.RegisterConstants;
import com.bgi.marine.dao.UserDao;
import com.bgi.marine.dto.RegisterDto;
import com.bgi.marine.service.RegisterService;
import com.bgi.marine.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Resource
    private UserDao userDao;
    @Resource
    private RegisterAgent registerAgent;

    @Override
    public ResponseMap register(RegisterDto registerDto, HttpSession session) {
        ResponseMap responseMap = ResponseMap.builder().build();
        if (!registerValidate(registerDto,responseMap)){
            //保存账户信息
            return responseMap;
        }
        session.setAttribute("userId",Integer.parseInt(registerAgent.registerUser(registerDto).toString()));
        session.setAttribute("userName",registerDto.getUserName());
        HashMap<String,Object> map = new HashMap<>();
        map.put("nickName",registerDto.getNickName());
        responseMap.setFlag(Constants.SUCCESS_FLAG);
        responseMap.setContent(map);
        return responseMap;
    }

    private boolean registerValidate(RegisterDto registerDto, ResponseMap responseMap){
        String userName = registerDto.getUserName();
        String password = registerDto.getPassword();
        String passwordRepeat = registerDto.getPasswordRepeat();
        String emailAddress = registerDto.getEmailAddress();
        if ("".equals(userName) || null == userName){
            CommonUtil.setErrorMessage(RegisterConstants.EMPTY_USER_NAME_FLAG, RegisterConstants.EMPTY_USER_NAME, responseMap);
            return false;
        } else if ("".equals(password) || null == password){
            CommonUtil.setErrorMessage(RegisterConstants.EMPTY_PASSWORD_FLAG, RegisterConstants.EMPTY_PASSWORD, responseMap);
            return false;
        } else if ("".equals(passwordRepeat) || null == passwordRepeat){
            CommonUtil.setErrorMessage(RegisterConstants.EMPTY_PASSWORD_REPEAT_FLAG, RegisterConstants.EMPTY_PASSWORD_REPEAT, responseMap);
            return false;
        } else if (!password.equals(passwordRepeat)){
            CommonUtil.setErrorMessage(RegisterConstants.PASSWORD_NOT_EQUAL_FLAG, RegisterConstants.PASSWORD_NOT_EQUAL, responseMap);
            return false;
        }
        if (userDao.queryUserByName(userName) > 0){
            CommonUtil.setErrorMessage(RegisterConstants.EXIST_USER_NAME_FLAG, RegisterConstants.EXIST_USER_NAME, responseMap);
            return false;
        }
        if (!"".equals(emailAddress) && null!=emailAddress){
            if (userDao.queryUserByEmailAddress(emailAddress) > 0){
                CommonUtil.setErrorMessage(RegisterConstants.EXIST_EMAIL_ADDRESS_FLAG, RegisterConstants.EXIST_EMAIL_ADDRESS, responseMap);
                return false;
            }
        }
        return true;
    }
}
