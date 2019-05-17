package com.company.heartbeatsignal.service;

import com.company.heartbeatsignal.dto.entity.AttentionDTO;
import com.company.heartbeatsignal.service.infc.Cruder;

import java.util.List;

/**
 * @author Liquid
 * @类名： AttentionService
 * @描述：
 * @date 2019/5/8
 */
public interface AttentionService extends Cruder<AttentionDTO>{
    public List<AttentionDTO> selectByUserId(AttentionDTO attentionDTO);
    List<AttentionDTO> selectByAttentionUserId(AttentionDTO attentionDTO);
}
