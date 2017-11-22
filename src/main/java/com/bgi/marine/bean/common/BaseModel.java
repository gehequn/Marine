package com.bgi.marine.bean.common;

import lombok.Data;

@Data
public class BaseModel{
    private Long id;
    private int isDeleted;
    private String extendedField;
}
