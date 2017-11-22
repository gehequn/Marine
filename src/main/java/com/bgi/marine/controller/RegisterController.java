package com.bgi.marine.controller;

import com.bgi.marine.bean.common.ResponseMap;
import com.bgi.marine.dto.RegisterDto;
import com.bgi.marine.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Register")
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @RequestMapping("/init")
    public String init() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMap register(@ModelAttribute RegisterDto registerDto, HttpSession session) {
        return registerService.register(registerDto, session);
    }
}
