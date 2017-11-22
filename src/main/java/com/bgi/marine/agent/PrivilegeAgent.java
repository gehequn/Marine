package com.bgi.marine.agent;

import com.bgi.marine.bean.vo.MenuVo;

import java.util.ArrayList;

public interface PrivilegeAgent {
    ArrayList<MenuVo> loadUserMenu(int userId);
}
