package com.company.heartbeatsignal.dto.entity;

import com.company.heartbeatsignal.dto.Convertible;
import com.company.heartbeatsignal.entity.Attention;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Liquid
 * @类名： AttentionDTO
 * @描述：
 * @date 2019/5/8
 */
@Data
public class AttentionDTO implements Serializable {
    private static final long serialVersionUID = 9132201952870298347L;
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 关联用户id
     */
    private Integer userId;

    /**
     * 关注者用户id
     */
    private Integer attentionUserId;

    private static AttentionConvert attentionConvert;

    static {
        attentionConvert = new AttentionConvert();
    }

    public Attention convertToAttentionLetter() {
        return attentionConvert.convertToDO(this);
    }

    public AttentionDTO convertToAttentionLetterDTO(Attention attention) {
        return attentionConvert.convertToDTO(attention);
    }

    public static class AttentionConvert implements Convertible<Attention, AttentionDTO> {

        @Override
        public Attention convertToDO(AttentionDTO attentionDTO) {
            Attention attention = new Attention();
            BeanUtils.copyProperties(attentionDTO, attention);
            return attention;
        }

        @Override
        public AttentionDTO convertToDTO(Attention attention) {
            AttentionDTO attentionDTO = new AttentionDTO();
            BeanUtils.copyProperties(attention, attentionDTO);
            return attentionDTO;
        }
    }

}
