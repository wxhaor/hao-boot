package com.wxhao.boot.base.exception;

/**
 * Created by wxhao on 2017/10/31.
 */
public class DecryptException extends RuntimeException {

    public DecryptException(String message) {
        super(message);
    }

    public DecryptException(String message, Throwable cause) {
        super(message, cause);
    }

}
