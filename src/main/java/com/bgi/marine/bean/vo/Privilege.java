package com.bgi.marine.bean.vo;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class Privilege implements Serializable {
    private static final long serialVersionUID = 117536897615406448L;

    private List<String> menuUrlList;
    private List<MenuVo> menuList;
}
