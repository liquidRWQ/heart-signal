package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.LabelMapper;
import com.company.heartbeatsignal.dto.entity.LabelDTO;
import com.company.heartbeatsignal.entity.Label;
import com.company.heartbeatsignal.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liquid
 * @类名： LabelServiceImpl
 * @描述：
 * @date 2019/5/8
 */
@Service("labelServiceImpl")
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelMapper labelMapper;

    @Override
    public void insert(LabelDTO labelDTO) {
        Label label = labelDTO.convertToUserBaseInfo();
        label.setAllTime();
        labelMapper.insert(label);
    }

    @Override
    public List<LabelDTO> selectAll() {
        List<Label> labels = labelMapper.selectAll();
        ArrayList<LabelDTO> labelDTOS = new ArrayList<>();
        for (Label label : labels) {
            labelDTOS.add(new LabelDTO().convertToUserBaseInfoDTO(label));
        }
        return labelDTOS;
    }

    @Override
    public LabelDTO selectByPrimary(LabelDTO labelDTO) {
        return new LabelDTO().convertToUserBaseInfoDTO(labelMapper.selectByPrimaryKey(labelDTO.getId()));
    }

    @Override
    public void updateByPrimary(LabelDTO labelDTO) {
        Label label = labelDTO.convertToUserBaseInfo();
        label.refreshLastUpdateTime();
        labelMapper.updateByPrimaryKeySelective(label);

    }

    @Override
    public void deleteByPrimary(LabelDTO labelDTO) {
        labelMapper.deleteByPrimaryKey(labelDTO.getId());
    }

    @Override
    public void updateLabelStatus(LabelDTO labelDTO) {

    }
}
