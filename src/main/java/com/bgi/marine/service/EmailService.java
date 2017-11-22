package com.bgi.marine.service;

import com.bgi.marine.bean.common.ResponseMap;
import com.bgi.marine.dto.EmailDto;
import org.springframework.stereotype.Service;

/**
 * Created by GeHeQun on 2017/11/10.
 */
@Service
public interface EmailService {
    ResponseMap sendEmail(EmailDto emailDto);
}
