package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.context.secret.cdk.CdkContext;
import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.CdkMapper;
import com.company.heartbeatsignal.dto.entity.CdkDTO;
import com.company.heartbeatsignal.dto.entity.VipDTO;
import com.company.heartbeatsignal.entity.Cdk;
import com.company.heartbeatsignal.exception.UserException;
import com.company.heartbeatsignal.service.CdkService;
import com.company.heartbeatsignal.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liquid
 * @类名： CdkServiceImpl
 * @描述：
 * @date 2019/5/8
 */
@Service("cdkServiceImpl")
public class CdkServiceImpl implements CdkService {

    private static final String CONVERTED = "已兑换";

    @Autowired
    private CdkMapper cdkMapper;

    @Autowired
    private CdkContext cdkContext;

    @Override
    public void insert(CdkDTO cdkDTO) {
        Cdk cdk = cdkDTO.convertToCdk();
        cdk.setAllTime();
        cdkMapper.insert(cdk);
    }

    @Override
    public List<CdkDTO> selectAll() {
        List<Cdk> cdks = cdkMapper.selectAll();
        ArrayList<CdkDTO> cdkDTOS = new ArrayList<>();
        for (Cdk cdk : cdks) {
            cdkDTOS.add(new CdkDTO().convertToCdkDTO(cdk));
        }

        return cdkDTOS;
    }

    @Override
    public CdkDTO selectByPrimary(CdkDTO cdkDTO) {

        return new CdkDTO().convertToCdkDTO(cdkMapper.selectByPrimaryKey(cdkDTO.getId()));
    }

    @Override
    public void updateByPrimary(CdkDTO cdkDTO) {
        Cdk cdk = cdkDTO.convertToCdk();
        cdk.refreshLastUpdateTime();
        cdkMapper.updateByPrimaryKeySelective(cdk);
    }

    @Override
    public void deleteByPrimary(CdkDTO cdkDTO) {
        cdkMapper.deleteByPrimaryKey(cdkDTO.getId());
    }

    @Override
    public void convertCdk(CdkDTO cdkDTO) {

        Cdk cdk = cdkMapper.selectOne(cdkDTO.convertToCdk());
        if (CONVERTED.equals(cdk.getStatus())) {
            throw new UserException("cdk已兑换");
        } else if (TimeUtils.getCurrentTime().after(cdk.getStopTime())) {
            throw new UserException("cdk已超时");
        }

        String reward = cdk.getReward();
        if ("vip".equals(reward)) {
            VipDTO vipDTO = new VipDTO();
            vipDTO.setUserId(cdkDTO.getUserId());
            vipDTO.setStopTime(TimeUtils.getAfterCurrentTime(90, ChronoUnit.DAYS));
            cdkContext.convertCdk("vipServiceImpl", vipDTO);
        }

    }
}
