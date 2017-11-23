package com.bgi.marine.agent;

import com.bgi.marine.bean.Menu;

import java.util.List;

public interface PrivilegeAgent {

    List<Menu> loadUserMenu();

    List<Menu> loadUserMenu(int userId);
}
