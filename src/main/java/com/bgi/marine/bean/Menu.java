package com.bgi.marine.bean;

import com.bgi.marine.bean.common.BaseModel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Menu extends BaseModel implements Serializable {

    private static final long serialVersionUID = -8833583120391310473L;

    private String menuCode;
    private String menuName;
    private int menuType;
    private String menuUrl;
    private String parentMenu;
}
