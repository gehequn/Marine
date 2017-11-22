package com.bgi.marine.controller;

import com.bgi.marine.bean.vo.UserVo;
import com.bgi.marine.dto.LoginDto;
import com.bgi.marine.util.CommonUtil;
import com.bgi.marine.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Welcome")
public class WelcomeController {
    private Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @RequestMapping("/init")
    public String init(HttpServletRequest request, HttpSession session) {
        CommonUtil.setRequest(session, request);
        return "welcome";
    }

    @RequestMapping("/record")
    @ResponseBody
    public String welcome(@ModelAttribute LoginDto loginDto){
        List<UserVo> list = new ArrayList<UserVo>();
        UserVo userVo;
        int i=1;
        while (i<=3){
            userVo = new UserVo();
            userVo.setId(i);
            userVo.setUserName("name"+i);
            userVo.setNickName("nickName"+i);
            userVo.setEmailAddress("address"+i);
            list.add(userVo);
            i++;
        }
        String json = null;
        try {
            json = JsonUtil.parseJson(list);
            json =  "{\"total\":" + 3 + ",\"rows\":" + json
                    + "}";
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return json;
    }
}
