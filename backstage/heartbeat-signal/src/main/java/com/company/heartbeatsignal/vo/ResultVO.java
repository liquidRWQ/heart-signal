package com.company.heartbeatsignal.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @className ResultBean
 * @auther Liquid
 * @description
 * @date 2018/11/11
 */
@Data
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = -8362519075967287843L;

    public static final int SUCCESS = 0;

    public static final int USER_FAIL = 1;

    public static final int UNCHECKED_EXCEPTION_FAIL = 2;

    public static final int CHECKED_EXCEPTION_FAIL = 3;

    public static final int UNKNOWN_EXCEPTION_FAIL = 4;

    private String msg = "success";

    private int code = SUCCESS;

    private T data;

    public ResultVO() {
        super();
    }

    public ResultVO(T data) {
        super();
        this.data = data;
    }

}
