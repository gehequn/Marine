package com.bgi.marine.service;

import com.bgi.marine.bean.common.ResponseMap;
import com.bgi.marine.dto.RegisterDto;

import javax.servlet.http.HttpSession;

public interface RegisterService {
    ResponseMap register(RegisterDto registerDto, HttpSession session);
}
