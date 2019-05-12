package com.company.heartbeatsignal.dto.entity;

import com.company.heartbeatsignal.dto.Convertible;
import com.company.heartbeatsignal.entity.Visitor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Liquid
 * @类名： VisitorDTO
 * @描述：
 * @date 2019/5/12
 */
@Data
public class VisitorDTO implements Serializable {
    private static final long serialVersionUID = -1879699304968603077L;

    /**
     * id
     */

    private Integer id;

    /**
     * 关联被访问用户id
     */
    private Integer userId;

    /**
     * 访客用户id
     */
    private Integer visitorUserId;

    /**
     * 来访时间
     */
    private Date visitTime;

    private static VisitorConvert visitorConvert;

    static {
        visitorConvert = new VisitorConvert();
    }

    public Visitor convertToVisitor() {
        return visitorConvert.convertToDO(this);
    }

    public VisitorDTO convertToVisitorDTO(Visitor visitor) {
        return visitorConvert.convertToDTO(visitor);
    }

    public static class VisitorConvert implements Convertible<Visitor, VisitorDTO> {

        @Override
        public Visitor convertToDO(VisitorDTO visitorDTO) {
            Visitor visitor = new Visitor();
            BeanUtils.copyProperties(visitorDTO, visitor);
            return visitor;
        }

        @Override
        public VisitorDTO convertToDTO(Visitor visitor) {
            VisitorDTO visitorDTO = new VisitorDTO();
            BeanUtils.copyProperties(visitor, visitorDTO);
            return visitorDTO;
        }
    }

}
