package com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper;

import com.company.heartbeatsignal.entity.Img;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/5/8
 */

@CacheNamespace
@org.apache.ibatis.annotations.Mapper
@Repository("imgMapper")
public interface ImgMapper extends Mapper<Img> {
}