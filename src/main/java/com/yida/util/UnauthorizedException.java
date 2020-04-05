package com.yida.util;

/**
 * @author zhangyifie
 * 权限的异常
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}
