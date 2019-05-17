package com.company.heartbeatsignal.service;

import com.company.heartbeatsignal.dto.entity.VisitorDTO;
import com.company.heartbeatsignal.service.infc.Cruder;

import java.util.List;

/**
 * @author Liquid
 * @类名： VisitorService
 * @描述：
 * @date 2019/5/8
 */
public interface VisitorService extends Cruder<VisitorDTO>{

    List<VisitorDTO> selectByUserId(VisitorDTO visitorDTO);

    List<VisitorDTO> selectByVisitorUserId(VisitorDTO visitorDTO);
}
