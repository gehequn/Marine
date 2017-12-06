package com.bgi.marine.bean;

import com.bgi.marine.bean.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization extends BaseModel implements Serializable {

    private static final long serialVersionUID = 4607613548452865383L;

    private String orgName;
    private int parentId;
    private int type;
}
