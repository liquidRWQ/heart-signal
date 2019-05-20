package com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper;

import com.company.heartbeatsignal.dto.entity.UserDTO;
import com.company.heartbeatsignal.entity.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/5/8
 */

@CacheNamespace
@org.apache.ibatis.annotations.Mapper
@Repository
public interface UserMapper extends Mapper<User> {

    Integer selectUserId(String userOpenid);

    List<User> setByPrimaryKeyList(List<Integer> ids);

    List<UserDTO> selectInIndex(String userId);
}