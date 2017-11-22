package com.bgi.marine.service.impl;

import com.bgi.marine.bean.common.ResponseMap;
import com.bgi.marine.constants.EmailConstants;
import com.bgi.marine.dto.EmailDto;
import com.bgi.marine.service.EmailService;
import com.bgi.marine.util.CommonUtil;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmailServiceImpl implements EmailService {

    private Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Override
    public ResponseMap sendEmail(EmailDto emailDto) {
        ResponseMap responseMap = null;
        try {

            String[] receiveAccountArr = emailDto.getReceiveMailAccount().split(";");
            if (receiveAccountArr.length == 0) {
                CommonUtil.setErrorMessage(EmailConstants.EMPTY_RECEIVE_ACCOUNT_FLAG, EmailConstants.EMPTY_RECEIVE_ACCOUNT, responseMap);
            } else {
//                receiveAccountArr

            }
        } catch (Exception e) {
            responseMap.setMessage(e.getMessage());
            logger.error(e.getMessage());
        }
        return responseMap;
    }
}
