package com.company.heartbeatsignal.service;

import com.company.heartbeatsignal.dto.entity.BadReportDTO;
import com.company.heartbeatsignal.service.infc.Cruder;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Liquid
 * @类名： BadReportService
 * @描述：
 * @date 2019/5/8
 */
public interface BadReportService extends Cruder<BadReportDTO>{
    void insertBadReportDTO(BadReportDTO badReportDTO, String realPath, MultipartFile[] files);
}
