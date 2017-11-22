package com.bgi.marine.bean;

import com.bgi.marine.bean.common.BaseModel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Email extends BaseModel implements Serializable {

    private static final long serialVersionUID = -6514561005358247306L;

    private String emailAddress;
    private String nickName;
}
