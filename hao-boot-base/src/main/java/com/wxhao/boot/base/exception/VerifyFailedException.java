package com.wxhao.boot.base.exception;

/**
 * Created by wxhao on 2017/10/25.
 */
public class VerifyFailedException extends RuntimeException {
    private static final long serialVersionUID = -3760524526493913977L;

    public VerifyFailedException(String message) {
        super(message);
    }

    public VerifyFailedException(String message, Throwable cause) {
        super(message, cause);
    }

}
