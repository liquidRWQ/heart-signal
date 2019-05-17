package com.company.heartbeatsignal.service.infc;

import java.util.List;

/**
 * @author Liquid
 * @类名： Cruder
 * @描述：
 * @date 2019/5/18
 */
public interface Cruder<T> {
    void insert(T t) throws Exception;

    List<T> selectAll();

    T selectByPrimary(T t);

    void updateByPrimary(T t);

    void deleteByPrimary(T t);
}
