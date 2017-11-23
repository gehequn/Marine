package com.bgi.marine.controller;

import com.bgi.marine.bean.common.ResponseMap;
import com.bgi.marine.dto.LoginDto;
import com.bgi.marine.util.CommonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Error")
public class ErrorController {


    @RequestMapping("/privilege")
    public String privilege() {
        return "privilege";
    }

}