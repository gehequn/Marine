package com.bgi.marine.controller;

import com.bgi.marine.bean.common.ResponseMap;
import com.bgi.marine.bean.vo.OrganizationVo;
import com.bgi.marine.constants.Constants;
import com.bgi.marine.service.OrganizationService;
import com.bgi.marine.util.CommonUtil;
import com.bgi.marine.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/Organization")
public class OrganizationController {

    private Logger logger = LoggerFactory.getLogger(OrganizationController.class);

    @Resource
    private OrganizationService organizationService;

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
            List<OrganizationVo> orgList = organizationService.getOrgTree();

//            String json = "[{\"text\":\"父亲节点1\"},{\"text\":\"父亲节点2\"}]";
            String json = JsonUtil.getOrganizationJson(orgList);
            responseMap= ResponseMap.builder().flag(Constants.SUCCESS_FLAG).message(json).build();
        }catch (Exception e){
            responseMap= ResponseMap.builder().flag(Constants.FAIL_FLAG).message(e.getMessage()).build();
            logger.error(e.toString());
        }
        return responseMap;
    }
}