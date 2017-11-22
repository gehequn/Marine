package com.bgi.marine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto implements Serializable {
    private static final long serialVersionUID = -6597283253089851641L;

    private String userName;
    private String emailAddress;
    private String nickName;
    private String mobile;
    private String password;
    private String passwordRepeat;
}
