package com.bgi.marine.bean;

import com.bgi.marine.bean.common.BaseModel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class Orginization extends BaseModel implements Serializable {

    private static final long serialVersionUID = 4607613548452865383L;

    private String OrgName;
    private int parentId;
    private int type;
}
