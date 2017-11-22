package com.bgi.marine.service;

import com.bgi.marine.bean.common.ResponseMap;
import com.bgi.marine.dto.LoginDto;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by GeHeQun on 2017/5/11.
 */
@Service
public interface LoginService {
    ResponseMap login(LoginDto loginDto, HttpSession session);
}
