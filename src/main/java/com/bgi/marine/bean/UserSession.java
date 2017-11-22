package com.bgi.marine.bean;

import lombok.Data;
import java.io.Serializable;

@Data
public class UserSession implements Serializable {
    private String userName;
    private Integer userId;
    private String nickName;
}
