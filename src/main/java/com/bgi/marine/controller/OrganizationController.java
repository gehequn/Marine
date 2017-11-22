package com.bgi.marine.controller;

import com.bgi.marine.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Organization")
public class OrganizationController {

    private Logger logger = LoggerFactory.getLogger(OrganizationController.class);

    @RequestMapping("/init")
    public String init(HttpServletRequest request, HttpSession session) {
        CommonUtil.setRequest(session, request);
        return "organization";
    }
}