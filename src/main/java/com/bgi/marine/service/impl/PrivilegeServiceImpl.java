package com.bgi.marine.service.impl;

import com.bgi.marine.agent.PrivilegeAgent;
import com.bgi.marine.bean.Menu;
import com.bgi.marine.bean.vo.MenuVo;
import com.bgi.marine.bean.vo.Privilege;
import com.bgi.marine.constants.Constants;
import com.bgi.marine.service.PrivilegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Resource
    private PrivilegeAgent privilegeAgent;

    @Override
    public Privilege loadUserMenu(int userType, int userId) {
        List<MenuVo> userMenuList = new ArrayList<>();
        List<Menu> menuList = new ArrayList<>();
        List<String> urlList = new ArrayList<>();
        if (userType == 0) {
            //admin用户,查询所有菜单
            menuList = privilegeAgent.loadUserMenu();
        } else {

        }
        //循环菜单
        menuList.forEach(menu -> {
            //添加用户可以看到的菜单url
            urlList.add(menu.getMenuUrl());
            if (menu.getParentMenu().equals(Constants.TOP_CODE)) {
                userMenuList.add(MenuVo.builder().menuCode(menu.getMenuCode()).menuName(menu.getMenuName()).menuType(menu.getMenuType()).menuUrl(menu.getMenuUrl()).childMenu(new ArrayList<>()).build());
            } else {
                if (userMenuList.size() > 0) {
                    for (MenuVo menuVo : userMenuList) {
                        if (menuVo.getMenuCode().equals(menu.getParentMenu())) {
                            menuVo.getChildMenu().add(MenuVo.builder().menuCode(menu.getMenuCode()).menuName(menu.getMenuName()).menuType(menu.getMenuType()).menuUrl(menu.getMenuUrl()).build());
                            break;
                        }
                    }
                }
            }
        });
        Privilege privilege = Privilege.builder().menuList(userMenuList).menuUrlList(urlList).build();
        return privilege;
    }
}
