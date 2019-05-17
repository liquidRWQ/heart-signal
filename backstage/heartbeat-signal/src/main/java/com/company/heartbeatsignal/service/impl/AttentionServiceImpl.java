package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.AttentionMapper;
import com.company.heartbeatsignal.dto.entity.AttentionDTO;
import com.company.heartbeatsignal.entity.Attention;
import com.company.heartbeatsignal.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liquid
 * @类名： AttentionServiceImpl
 * @描述：
 * @date 2019/5/8
 */
@Service("attentionServiceImpl")
public class AttentionServiceImpl implements AttentionService {

    @Autowired
    private AttentionMapper attentionMapper;

    @Override
    public void insert(AttentionDTO attentionDTO) {
        Attention attention = attentionDTO.convertToAttention();
        attention.setAllTime();
        attentionMapper.insert(attention);
    }

    @Override
    public List<AttentionDTO> selectAll() {
        List<Attention> attentions = attentionMapper.selectAll();
        List<AttentionDTO> attentionDTOS = new ArrayList<>();
        for (Attention attention : attentions) {
            attentionDTOS.add(new AttentionDTO().convertToAttentionDTO(attention));
        }
        return attentionDTOS;
    }

    @Override
    public AttentionDTO selectByPrimary(AttentionDTO attentionDTO) {
        return new AttentionDTO().convertToAttentionDTO(attentionMapper.selectByPrimaryKey(attentionDTO.getId()));
    }

    @Override
    public void updateByPrimary(AttentionDTO attentionDTO) {
        Attention attention = attentionDTO.convertToAttention();
        attention.refreshLastUpdateTime();
        attentionMapper.updateByPrimaryKeySelective(attention);
    }

    @Override
    public void deleteByPrimary(AttentionDTO attentionDTO) {
        attentionMapper.deleteByPrimaryKey(attentionDTO.getId());
    }

    @Override
    public List<AttentionDTO> selectByUserId(AttentionDTO attentionDTO) {
        List<Attention> attentions = attentionMapper.select(attentionDTO.convertToAttention());
        ArrayList<AttentionDTO> attentionDTOS = new ArrayList<>();
        for (Attention attention : attentions) {
            attentionDTOS.add(new AttentionDTO().convertToAttentionDTO(attention));
        }
        return attentionDTOS;
    }

    @Override
    public List<AttentionDTO> selectByAttentionUserId(AttentionDTO attentionDTO) {
        List<Attention> attentions = attentionMapper.select(attentionDTO.convertToAttention());
        ArrayList<AttentionDTO> attentionDTOS = new ArrayList<>();
        for (Attention attention : attentions) {
            attentionDTOS.add(new AttentionDTO().convertToAttentionDTO(attention));
        }
        return attentionDTOS;
    }
}

