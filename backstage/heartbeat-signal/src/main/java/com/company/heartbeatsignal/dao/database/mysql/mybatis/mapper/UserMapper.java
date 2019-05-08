package com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper;

import com.company.heartbeatsignal.entity.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @className UserMapper
 * @auther Liquid
 * @description
 * @date 2018/11/21
 */
@CacheNamespace
@org.apache.ibatis.annotations.Mapper
@Repository("userMapper")
public interface UserMapper extends Mapper<User> {

}