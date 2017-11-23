package com.bgi.marine.interceptor;

import com.bgi.marine.bean.vo.Privilege;
import com.bgi.marine.constants.Constants;
import com.bgi.marine.constants.LoginConstants;
import com.bgi.marine.exception.AuthorizationException;
import com.bgi.marine.exception.PrivilegeException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by GeHeQun on 2017/5/10.
 * 处理登录时候的没有用户session的拦截器
 */
public class LoginSecurityInterceptor implements HandlerInterceptor {

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

        //处理需要拦截的url
        HttpSession session = request.getSession();
        if (null == session.getAttribute("userId")){
            //处理无session的用户
            throw new AuthorizationException();
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
