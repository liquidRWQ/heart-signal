package com.company.heartbeatsignal.dto.entity;

import com.company.heartbeatsignal.dto.Convertible;
import com.company.heartbeatsignal.entity.Label;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： LabelDTO
 * @描述：
 * @date 2019/5/11
 */
@Data
public class LabelDTO implements Serializable {
    private static final long serialVersionUID = 9149817509823712096L;

    /**
     * id
     */
    private Integer id;

    /**
     * 关联用户id
     */
    private Integer userId;

    /**
     * 标签分类
     */
    private String labelClass;

    /**
     * 标签名
     */
    private String labelName;

    /**
     * 标签认可状态
     */
    private String status;

    private static LabelConvert labelConvert;

    static {
        labelConvert = new LabelConvert();
    }

    public Label convertToUserBaseInfo() {
        return labelConvert.convertToDO(this);
    }

    public LabelDTO convertToUserBaseInfoDTO(Label label) {
        return labelConvert.convertToDTO(label);
    }

    public static class LabelConvert implements Convertible<Label, LabelDTO> {

        @Override
        public Label convertToDO(LabelDTO labelDTO) {
            Label label = new Label();
            BeanUtils.copyProperties(labelDTO, label);
            return label;
        }

        @Override
        public LabelDTO convertToDTO(Label label) {
            LabelDTO labelDTO = new LabelDTO();
            BeanUtils.copyProperties(label, labelDTO);
            return labelDTO;
        }
    }

}
