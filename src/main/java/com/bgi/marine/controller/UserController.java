package com.bgi.marine.controller;

import com.bgi.marine.bean.vo.UserVo;
import com.bgi.marine.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/User")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping("/userInfo")
    public String userInfo(HttpSession session, HttpServletRequest request){
        Integer userId = (Integer) session.getAttribute("userId");
        UserVo user = userService.getUserInfo(userId);
        request.setAttribute("userInfo",user);
        return "userInfo";
    }
}