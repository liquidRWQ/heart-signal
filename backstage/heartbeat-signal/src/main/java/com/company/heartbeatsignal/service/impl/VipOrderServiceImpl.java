package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.context.template.TemplatorContext;
import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.VipOrderMapper;
import com.company.heartbeatsignal.dto.entity.VipOrderDTO;
import com.company.heartbeatsignal.dto.template.WeChatTemplateDTO;
import com.company.heartbeatsignal.entity.VipOrder;
import com.company.heartbeatsignal.service.VipOrderService;
import com.company.heartbeatsignal.util.TemplateParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liquid
 * @类名： VipOrderServiceImpl
 * @描述：
 * @date 2019/5/17
 */
@Service("vipOrderServiceImpl")
public class VipOrderServiceImpl implements VipOrderService {

    @Autowired
    private VipOrderMapper vipOrderMapper;

    @Autowired
    private TemplatorContext templatorContext;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insert(VipOrderDTO vipOrderDTO) throws Exception {
        VipOrder vipOrder = vipOrderDTO.convertToVipOrder();
        vipOrder.setAllTime();
        vipOrder.setRandomId();
        vipOrderMapper.insert(vipOrder);
        String params = TemplateParamsUtils.getVipOrderJsonParams(vipOrderDTO);
        WeChatTemplateDTO weChatTemplateDTO = new WeChatTemplateDTO();
        templatorContext.sendTemplate(weChatTemplateDTO, "weChatOrderSend");

    }

    @Override
    public List<VipOrderDTO> selectAll() {
        List<VipOrder> vipOrders = vipOrderMapper.selectAll();
        ArrayList<VipOrderDTO> vipOrderDTOS = new ArrayList<>();
        for (VipOrder vipOrder : vipOrders) {
            vipOrderDTOS.add(new VipOrderDTO().convertToVipOrderDTO(vipOrder));
        }
        return vipOrderDTOS;
    }

    @Override
    public VipOrderDTO selectByPrimary(VipOrderDTO vipOrderDTO) {
        return new VipOrderDTO().convertToVipOrderDTO(vipOrderMapper.selectByPrimaryKey(vipOrderDTO.getId()));
    }

    @Override
    public void updateByPrimary(VipOrderDTO vipOrderDTO) {
        VipOrder vipOrder = vipOrderDTO.convertToVipOrder();
        vipOrder.refreshLastUpdateTime();
        vipOrderMapper.updateByPrimaryKeySelective(vipOrder);
    }

    @Override
    public void deleteByPrimary(VipOrderDTO vipOrderDTO) {
        vipOrderMapper.deleteByPrimaryKey(vipOrderDTO.getId());
    }
}
