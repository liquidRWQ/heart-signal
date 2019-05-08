package com.company.heartbeatsignal.exception;

/**
 * @author Liquid
 * @类名： BusinessException
 * @描述： 用户操作不当导致的异常
 * @date 2019/3/29
 */
public class UserException extends RuntimeException {

    private static final long serialVersionUID = -897026698927247801L;

    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    protected UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
