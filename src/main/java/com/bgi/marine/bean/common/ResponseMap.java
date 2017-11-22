package com.bgi.marine.bean.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

@Data
@Builder
public class ResponseMap implements Serializable{
    private static final long serialVersionUID = -2574143637194315408L;

    private Integer flag;
    private String message;
    private HashMap content;

}
