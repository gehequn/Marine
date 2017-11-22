package com.bgi.marine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto implements Serializable {
    private static final long serialVersionUID = 7205205640422668554L;

    private String userName;
    private String password;
}
