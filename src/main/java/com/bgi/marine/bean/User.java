package com.bgi.marine.bean;

import com.bgi.marine.bean.common.BaseModel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class User extends BaseModel implements Serializable {

    private static final long serialVersionUID = 2787094115336400294L;

    private String userName;

    private String nickName;

    private String password;

    private String emailAddress;

    private String mobile;
}
