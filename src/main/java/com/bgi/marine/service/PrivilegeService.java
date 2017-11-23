package com.bgi.marine.service;

import com.bgi.marine.bean.vo.Privilege;

public interface PrivilegeService {
    Privilege loadUserMenu(int userType, int userId);
}
