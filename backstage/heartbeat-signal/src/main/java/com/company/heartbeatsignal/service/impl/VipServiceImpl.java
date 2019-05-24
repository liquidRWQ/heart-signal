package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.VipMapper;
import com.company.heartbeatsignal.dto.entity.VipDTO;
import com.company.heartbeatsignal.entity.Vip;
import com.company.heartbeatsignal.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liquid
 * @类名： VipServiceImpl
 * @描述：
 * @date 2019/5/8
 */
@Service("vipServiceImpl")
public class VipServiceImpl implements VipService {

    @Autowired
    private VipMapper vipMapper;

    @Override
    public void insert(VipDTO vipDTO) {
        Vip vip = vipDTO.convertToVip();
        vip.setAllTime();
        vipMapper.insert(vip);
    }

    @Override
    public List<VipDTO> selectAll() {
        List<Vip> vips = vipMapper.selectAll();
        ArrayList<VipDTO> vipDTOS = new ArrayList<>();
        for (Vip vip : vips) {
            vipDTOS.add(new VipDTO().convertToVipDTO(vip));
        }
        return vipDTOS;
    }

    @Override
    public VipDTO selectByPrimary(VipDTO vipDTO) {
        return new VipDTO().convertToVipDTO(vipMapper.selectByPrimaryKey(vipDTO.getId()));
    }

    @Override
    public void updateByPrimary(VipDTO vipDTO) {
        Vip vip = vipDTO.convertToVip();
        vip.refreshLastUpdateTime();
        vipMapper.updateByPrimaryKeySelective(vip);
    }

    @Override
    public void deleteByPrimary(VipDTO vipDTO) {
        vipMapper.deleteByPrimaryKey(vipDTO.getId());
    }

    @Override
    public VipDTO selectByUserId(VipDTO vipDTO) {
        return new VipDTO().convertToVipDTO(vipMapper.selectOne(vipDTO.convertToVip()));
    }

    @Override
    public void convert(VipDTO vipDTO) {
        insert(vipDTO);
    }
}
