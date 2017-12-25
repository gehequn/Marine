package com.bgi.marine.controller;

import com.bgi.marine.bean.vo.UserVo;
import com.bgi.marine.constants.LoginConstants;
import com.bgi.marine.dto.LoginDto;
import com.bgi.marine.dto.UserDto;
import com.bgi.marine.service.UserService;
import com.bgi.marine.util.CommonUtil;
import com.bgi.marine.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping("/init")
    public String init(HttpSession session, HttpServletRequest request) {
//        Integer userId = (Integer) session.getAttribute(LoginConstants.USER_ID);
//        UserVo user = userService.getUserInfo(userId);
//        request.setAttribute("userInfo", user);
//        CommonUtil.setRequest(session, request);
        CommonUtil.setRequest(session, request);
        return "user";
    }

    @RequestMapping("/editInit")
    public String editInit(HttpSession session, HttpServletRequest request) {
//        Integer userId = (Integer) session.getAttribute(LoginConstants.USER_ID);
//        UserVo user = userService.getUserInfo(userId);
//        request.setAttribute("userInfo", user);
//        CommonUtil.setRequest(session, request);
        CommonUtil.setRequest(session, request);
        return "userEdit";
    }

    @RequestMapping("/userInfo")
    public String userInfo(HttpSession session, HttpServletRequest request) {
        Integer userId = (Integer) session.getAttribute(LoginConstants.USER_ID);
        UserVo user = userService.getUserInfo(userId);
        request.setAttribute("userInfo", user);
        CommonUtil.setRequest(session, request);
        return "userInfo";
    }

    @RequestMapping("/record")
    @ResponseBody
    public String record(@ModelAttribute UserDto userDto,HttpSession session) {
//        List<UserVo> list = new ArrayList<UserVo>();
//        UserVo userVo;
//        int i = 1;
//        while (i <= 3) {
//            userVo = new UserVo();
//            userVo.setId(i);
//            userVo.setUserName("name" + i);
//            userVo.setNickName("nickName" + i);
//            userVo.setEmailAddress("address" + i);
//            list.add(userVo);
//            i++;
//        }
        List<UserVo> userVoList = userService.getUserList();
        String json = null;
        try {
            json = JsonUtil.parseJson(userVoList);
            json = "{\"total\":" + userVoList.size() + ",\"rows\":" + json
                    + "}";
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return json;
    }
}