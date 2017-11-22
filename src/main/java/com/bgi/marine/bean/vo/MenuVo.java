package com.bgi.marine.bean.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@Builder
public class MenuVo implements Serializable {
    private static final long serialVersionUID = 2267643446478563627L;

    private String menuCode;
    private String menuName;
    private String menuUrl;
    private int menuType;
    private ArrayList<MenuVo> childMenu;
}
