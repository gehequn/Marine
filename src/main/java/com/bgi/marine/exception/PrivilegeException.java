package com.bgi.marine.exception;

import com.bgi.marine.constants.ErrorConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户处理无权限查看页面（非法url输入）到404页面
 */
public class PrivilegeException extends Exception {
    private static final long serialVersionUID = 1731789276784358029L;
    private Logger logger = LoggerFactory.getLogger(PrivilegeException.class);

    public PrivilegeException(){
        logger.error(ErrorConstants.USER_PRIVILEGE);
    }
}
