package com.wxhao.boot.base.exception;

/**
 * Created by wxhao on 2017/10/31.
 */
public class SignatureFailedException extends RuntimeException{

    public SignatureFailedException(String message) {
        super(message);
    }

    public SignatureFailedException(String message, Throwable cause) {
        super(message, cause);
    }

}
