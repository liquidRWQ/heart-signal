package com.company.heartbeatsignal.dto.entity;

import com.company.heartbeatsignal.dto.Convertible;
import com.company.heartbeatsignal.entity.BadReport;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： BadReportDTO
 * @描述：
 * @date 2019/5/11
 */
@Data
public class BadReportDTO implements Serializable {
    private static final long serialVersionUID = -8266832502047842209L;
    /**
     * 举报id
     */
    private Integer id;

    /**
     * 举报原因
     */
    private String reportReason;

    /**
     * 举报用户id
     */
    private Integer userId;

    /**
     * 举报截图
     */
    private String imgPath;

    private static BadReportConvert badReportConvert;

    static {
        badReportConvert = new BadReportConvert();
    }

    public BadReport convertToBadReport() {

        return badReportConvert.convertToDO(this);
    }

    public BadReportDTO convertToBadReportDTO(BadReport badReport) {
        return badReportConvert.convertToDTO(badReport);
    }

    public static class BadReportConvert implements Convertible<BadReport, BadReportDTO> {

        @Override
        public BadReport convertToDO(BadReportDTO badReportDTO) {
            BadReport badReport = new BadReport();
            BeanUtils.copyProperties(badReportDTO, badReport);
            return badReport;
        }

        @Override
        public BadReportDTO convertToDTO(BadReport badReport) {
            BadReportDTO badReportDTO = new BadReportDTO();
            BeanUtils.copyProperties(badReport, badReportDTO);
            return badReportDTO;
        }
    }
}
