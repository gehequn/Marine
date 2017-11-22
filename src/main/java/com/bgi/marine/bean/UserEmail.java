package com.bgi.marine.bean;

import com.bgi.marine.bean.common.BaseModel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by GeHeQun on 2017/5/9.
 */
@Data
@Builder
public class UserEmail extends BaseModel implements Serializable {
    private static final long serialVersionUID = -1181103539774065156L;

    private int userId;
    private int emailId;
    private String emailAddress;
}
