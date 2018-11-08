package com.wxhao.boot.base.exception;

/**
 * Created by wxhao on 2017/10/31.
 */
public class InitialKeyException extends RuntimeException {

    public InitialKeyException(String message) {
        super(message);
    }

    public InitialKeyException(String message, Throwable cause) {
        super(message, cause);
    }

}
