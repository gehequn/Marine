package com.bgi.marine.controller;

import com.bgi.marine.bean.common.ResponseMap;
import com.bgi.marine.bean.vo.OrganizationVo;
import com.bgi.marine.constants.Constants;
import com.bgi.marine.dto.OrganizationDto;
import com.bgi.marine.service.OrganizationService;
import com.bgi.marine.util.CommonUtil;
import com.bgi.marine.util.JsonUtil;
import net.sf.json.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping("/editInit")
    public String editInit(HttpServletRequest request, HttpSession session){
        CommonUtil.setRequest(session, request);
        return "organizationEdit";
    }

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

    @RequestMapping("/addOrganization")
    @ResponseBody
    public ResponseMap addOrganization(@ModelAttribute OrganizationDto organizationDto){
        ResponseMap responseMap;
        try {
            responseMap= ResponseMap.builder().flag(Constants.SUCCESS_FLAG).message(JsonUtil.parseJson(organizationService.addOrganization(organizationDto))).build();
        }catch (Exception e){
            responseMap= ResponseMap.builder().flag(Constants.FAIL_FLAG).message(e.getMessage()).build();
            logger.error(e.toString());
        }
        return responseMap;
    }

    @RequestMapping("/editOrganization")
    @ResponseBody
    public ResponseMap editOrganization(@ModelAttribute OrganizationDto organizationDto){
        ResponseMap responseMap;
        try {
            organizationService.editOrganization(organizationDto);
            responseMap= ResponseMap.builder().flag(Constants.SUCCESS_FLAG).build();
        }catch (Exception e){
            responseMap= ResponseMap.builder().flag(Constants.FAIL_FLAG).message(e.getMessage()).build();
            logger.error(e.toString());
        }
        return responseMap;
    }

    @RequestMapping("/delOrganization")
    @ResponseBody
    public ResponseMap delOrganization(@ModelAttribute OrganizationDto organizationDto){
        ResponseMap responseMap;
        try {
            organizationService.delOrganization(organizationDto);
            responseMap= ResponseMap.builder().flag(Constants.SUCCESS_FLAG).build();
        }catch (Exception e){
            responseMap= ResponseMap.builder().flag(Constants.FAIL_FLAG).message(e.getMessage()).build();
            logger.error(e.toString());
        }
        return responseMap;
    }

    @RequestMapping("/getOrgUpList")
    @ResponseBody
    public ResponseMap getOrgUpList(@ModelAttribute OrganizationDto organizationDto){
        ResponseMap responseMap;
        try {
            responseMap= ResponseMap.builder().flag(Constants.SUCCESS_FLAG).message(JsonUtil.parseJson(organizationService.getOrgUpList(organizationDto))).build();
        }catch (Exception e){
            responseMap= ResponseMap.builder().flag(Constants.FAIL_FLAG).message(e.getMessage()).build();
            logger.error(e.toString());
        }
        return responseMap;
    }
}