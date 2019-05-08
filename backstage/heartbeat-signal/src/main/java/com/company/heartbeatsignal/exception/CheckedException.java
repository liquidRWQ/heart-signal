package com.company.heartbeatsignal.exception;

/**
* @类名： CheckedException
*
* @author Liquid
*
* @描述： 受检异常，系统运行中可能出现的由于系统调用其他服务出现的无法控制的异常
*
* @date   2018/12/28
*/
public class CheckedException extends Exception{
    private static final long serialVersionUID = 492046217703082339L;

    public CheckedException() {
        super();
    }

    public CheckedException(String message) {
        super(message);
    }

    public CheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckedException(Throwable cause) {
        super(cause);
    }

    protected CheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
