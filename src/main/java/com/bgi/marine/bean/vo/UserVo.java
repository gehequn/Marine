package com.bgi.marine.bean.vo;

import lombok.*;

import java.io.Serializable;

/**
 * Created by GeHeQun on 2017/5/12.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserVo implements Serializable{
    private static final long serialVersionUID = 7990288180436786950L;

    private int id;
    private String userName;
    private String nickName;
    private String password;
    private String emailAddress;
    private int userType;

}
