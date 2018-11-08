package com.wxhao.boot.base.exception;

/**
 * Created by wxhao on 2017/10/31.
 */
public class EncryptException extends RuntimeException {

    public EncryptException(String message) {
        super(message);
    }

    public EncryptException(String message, Throwable cause) {
        super(message, cause);
    }

}
