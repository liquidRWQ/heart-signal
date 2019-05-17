package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.VisitorMapper;
import com.company.heartbeatsignal.dto.entity.VisitorDTO;
import com.company.heartbeatsignal.entity.Visitor;
import com.company.heartbeatsignal.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liquid
 * @类名： VisitorServiceImpl
 * @描述：
 * @date 2019/5/8
 */
@Service("visitorServiceImpl")
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorMapper visitorMapper;

    @Override
    public void insert(VisitorDTO visitorDTO) {
        Visitor visitor = visitorDTO.convertToVisitor();
        visitor.setAllTime();
        visitorMapper.insert(visitor);
    }

    @Override
    public List<VisitorDTO> selectAll() {
        List<Visitor> visitors = visitorMapper.selectAll();
        ArrayList<VisitorDTO> visitorDTOS = new ArrayList<>();
        for (Visitor visitor : visitors) {
            visitorDTOS.add(new VisitorDTO().convertToVisitorDTO(visitor));
        }
        return visitorDTOS;
    }

    @Override
    public VisitorDTO selectByPrimary(VisitorDTO visitorDTO) {

        return new VisitorDTO().convertToVisitorDTO(visitorMapper.selectByPrimaryKey(visitorDTO.getId()));
    }

    @Override
    public void updateByPrimary(VisitorDTO visitorDTO) {
        Visitor visitor = visitorDTO.convertToVisitor();
        visitor.refreshLastUpdateTime();
        visitorMapper.updateByPrimaryKeySelective(visitor);
    }

    @Override
    public void deleteByPrimary(VisitorDTO visitorDTO) {
        visitorMapper.deleteByPrimaryKey(visitorDTO.getId());
    }

    @Override
    public List<VisitorDTO> selectByUserId(VisitorDTO visitorDTO) {
        List<Visitor> visitors = visitorMapper.select(visitorDTO.convertToVisitor());
        ArrayList<VisitorDTO> visitorDTOS = new ArrayList<>();
        for (Visitor visitor : visitors) {
            visitorDTOS.add(new VisitorDTO().convertToVisitorDTO(visitor));
        }

        return visitorDTOS;
    }

    @Override
    public List<VisitorDTO> selectByVisitorUserId(VisitorDTO visitorDTO) {
        List<Visitor> visitors = visitorMapper.select(visitorDTO.convertToVisitor());
        ArrayList<VisitorDTO> visitorDTOS = new ArrayList<>();
        for (Visitor visitor : visitors) {
            visitorDTOS.add(new VisitorDTO().convertToVisitorDTO(visitor));
        }
        return visitorDTOS;
    }
}
