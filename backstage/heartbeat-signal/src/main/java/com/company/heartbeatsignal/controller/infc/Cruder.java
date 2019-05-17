package com.company.heartbeatsignal.controller.infc;

import com.company.heartbeatsignal.result.ResultBean;

/**
 * @author Liquid
 * @类名： Cruder
 * @描述：
 * @date 2019/5/18
 */
public interface Cruder<T> {

    ResultBean getOne(T t);

    ResultBean getAll();

    ResultBean addOne(T t) throws Exception;

    ResultBean updateOne(T t);

    ResultBean deleteOne(T t);
}
