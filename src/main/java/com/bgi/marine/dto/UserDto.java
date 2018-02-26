package com.bgi.marine.dto;

import com.bgi.marine.bean.common.QueryParams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends QueryParams implements Serializable {

    private static final long serialVersionUID = -2526322291043174951L;

    private String userName;
    private String password;
    private Integer operaUserId;
}
