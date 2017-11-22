package com.bgi.marine.bean;

import com.bgi.marine.bean.common.BaseModel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class Position extends BaseModel implements Serializable {

    private static final long serialVersionUID = -2319792700038354678L;

    private int userId;
    private int orgId;
    private int positionType;
}
