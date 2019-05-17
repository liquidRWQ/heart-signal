package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.BadReportMapper;
import com.company.heartbeatsignal.dto.entity.BadReportDTO;
import com.company.heartbeatsignal.entity.BadReport;
import com.company.heartbeatsignal.service.BadReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liquid
 * @类名： BadReportServiceImpl
 * @描述：
 * @date 2019/5/8
 */
@Service("badReportServiceImpl")
public class BadReportServiceImpl implements BadReportService {


    @Autowired
    private BadReportMapper badReportMapper;

    @Override
    public void insert(BadReportDTO badReportDTO) {
        BadReport badReport = badReportDTO.convertToBadReport();
        badReport.setAllTime();
        badReportMapper.insert(badReport);
    }

    @Override
    public List<BadReportDTO> selectAll() {
        List<BadReport> badReports = badReportMapper.selectAll();
        List<BadReportDTO> badReportDTOS = new ArrayList<>();
        for (BadReport badReport : badReports) {
            badReportDTOS.add(new BadReportDTO().convertToBadReportDTO(badReport));
        }
        return badReportDTOS;
    }

    @Override
    public BadReportDTO selectByPrimary(BadReportDTO badReportDTO) {
        return new BadReportDTO().convertToBadReportDTO(badReportMapper.selectByPrimaryKey(badReportDTO.getId()));
    }

    @Override
    public void updateByPrimary(BadReportDTO badReportDTO) {
        BadReport badReport = badReportDTO.convertToBadReport();
        badReport.refreshLastUpdateTime();
        badReportMapper.updateByPrimaryKeySelective(badReport);
    }

    @Override
    public void deleteByPrimary(BadReportDTO badReportDTO) {
        badReportMapper.deleteByPrimaryKey(badReportDTO.getId());
    }
}
