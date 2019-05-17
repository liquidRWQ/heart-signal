package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.CdkMapper;
import com.company.heartbeatsignal.dto.entity.CdkDTO;
import com.company.heartbeatsignal.entity.Cdk;
import com.company.heartbeatsignal.service.CdkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private CdkMapper cdkMapper;

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
}
