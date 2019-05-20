package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.BadReportMapper;
import com.company.heartbeatsignal.dto.entity.BadReportDTO;
import com.company.heartbeatsignal.dto.other.FilesDTO;
import com.company.heartbeatsignal.entity.BadReport;
import com.company.heartbeatsignal.service.BadReportService;
import com.company.heartbeatsignal.util.FileUpLoadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    private static final String FOLDER_NAME = "bad_report";

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

    @Override
    public void insertBadReportDTO(BadReportDTO badReportDTO, String realPath, MultipartFile[] files) {
        FilesDTO filesDTO = new FilesDTO();
        filesDTO.setFolderName(FOLDER_NAME);
        filesDTO.setMultipartFiles(files);
        filesDTO.setRealPath(realPath);
        filesDTO.setSecondFolderName("report_" + badReportDTO.getUserId());
        FileUpLoadUtils.setFilesToServer(filesDTO);
        List<String> paths = filesDTO.getPaths();
        BadReportDTO badReportDTO1 = new BadReportDTO();
        BadReport badReport;
        for (int i = 0, length = files.length; i < length; i++) {
            badReportDTO1.setImgPath(paths.get(i));
            badReport = badReportDTO1.convertToBadReport();
            badReport.setAllTime();
            badReportMapper.insert(badReport);
        }
    }
}
