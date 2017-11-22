package com.bgi.marine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto implements Serializable {

    private String receiveMailAccount;
    private String sendMailAccount;
    private String sendMailPassword;

}
