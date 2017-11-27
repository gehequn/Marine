package com.bgi.marine.interceptor;

import com.bgi.marine.bean.vo.Privilege;
import com.bgi.marine.constants.Constants;
import com.bgi.marine.constants.LoginConstants;
import com.bgi.marine.exception.AuthorizationException;
import com.bgi.marine.exception.PrivilegeException;
import com.bgi.marine.javaEnum.Ajax;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class PrivilegeInterceptor implements HandlerInterceptor {

    private List<String> excludedUrls;

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //处理不需要拦截的url
        String requestUri = request.getRequestURI();
        for (String url : excludedUrls) {
            if (requestUri.endsWith(url)) {
                return true;
            }
        }

        HttpSession session = request.getSession();
        List<String> urlList = ((Privilege)session.getAttribute(LoginConstants.USER_PRIVILEGE)).getMenuUrlList();
        for (String url : urlList){
            if (requestUri.endsWith(url)){
                return true;
            }
        }
        //处理ajax的url
        for (Ajax ajaxUrl : Ajax.values()){
            if (ajaxUrl.getUrl().endsWith(requestUri)){
                return true;
            }
        }
        throw new PrivilegeException();
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
