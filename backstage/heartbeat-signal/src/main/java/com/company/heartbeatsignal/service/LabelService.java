package com.company.heartbeatsignal.service;

import com.company.heartbeatsignal.dto.entity.LabelDTO;
import com.company.heartbeatsignal.service.infc.Cruder;

import java.util.List;

/**
 * @author Liquid
 * @类名： LabelService
 * @描述：
 * @date 2019/5/8
 */
public interface LabelService extends Cruder<LabelDTO>{

    void updateLabelStatus(LabelDTO labelDTO);

    List<LabelDTO> selectLabelsByUserId(LabelDTO labelDTO);
}
