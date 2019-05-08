package com.company.heartbeatsignal.exception;

/**
* @类名： UnCheckedException
*
* @author Liquid
*
* @描述： 不受检异常，因代码逻辑错误的异常
*
* @date   2018/12/28
*/
public class UnCheckedException extends RuntimeException{
    private static final long serialVersionUID = -3880128756190050605L;

    public UnCheckedException() {
        super();
    }

    public UnCheckedException(String message) {
        super(message);
    }

    public UnCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnCheckedException(Throwable cause) {
        super(cause);
    }

    protected UnCheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
