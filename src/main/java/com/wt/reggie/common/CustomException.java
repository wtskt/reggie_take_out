package com.wt.reggie.common;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 自定义业务异常
 */
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
