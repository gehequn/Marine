package com.bgi.marine.service;

import com.bgi.marine.bean.common.ResponseMap;
import com.bgi.marine.dto.LoginDto;

import javax.servlet.http.HttpSession;

public interface LoginService {
    ResponseMap login(LoginDto loginDto, HttpSession session);
}
