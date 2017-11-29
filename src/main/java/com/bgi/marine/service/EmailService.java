package com.bgi.marine.service;

import com.bgi.marine.bean.common.ResponseMap;
import com.bgi.marine.dto.EmailDto;

/**
 * Created by GeHeQun on 2017/11/10.
 */

public interface EmailService {
    ResponseMap sendEmail(EmailDto emailDto);
}
