package com.bgi.marine.controller;

import com.bgi.marine.bean.common.ResponseMap;
import com.bgi.marine.constants.Constants;
import com.bgi.marine.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    ///Organization/getTree

    @RequestMapping("/getTree")
    @ResponseBody
    public ResponseMap getTree(){
        ResponseMap responseMap;
        try {
            String json = "[{\"text\":\"父亲节点1\"},{\"text\":\"父亲节点2\"}]";
            responseMap= ResponseMap.builder().flag(Constants.SUCCESS_FLAG).message(json).build();
        }catch (Exception e){
            responseMap= ResponseMap.builder().flag(Constants.FAIL_FLAG).message(e.getMessage()).build();
            logger.error(e.toString());
        }
        return responseMap;
    }
}