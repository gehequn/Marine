package com.bgi.marine.controller;

import com.bgi.marine.bean.common.ResponseMap;
import com.bgi.marine.dto.LoginDto;
import com.bgi.marine.service.LoginService;
import com.bgi.marine.util.CommonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/welcome")
    @ResponseBody
    public ResponseMap welcome(@ModelAttribute LoginDto loginDto, HttpSession session) {
        return loginService.login(loginDto, session);
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        CommonUtil.removeSession(session);
        return "login";
    }
}