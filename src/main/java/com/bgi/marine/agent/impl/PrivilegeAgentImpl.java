package com.bgi.marine.agent.impl;

import com.bgi.marine.agent.PrivilegeAgent;
import com.bgi.marine.bean.Menu;
import com.bgi.marine.dao.MenuDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrivilegeAgentImpl implements PrivilegeAgent {

    @Resource
    MenuDao menuDao;

    @Override
    public List<Menu> loadUserMenu() {
        return menuDao.queryAll();
    }

    @Override
    public List<Menu> loadUserMenu(int userId) {

        return null;
    }
}
