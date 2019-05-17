package com.company.heartbeatsignal.dto.entity;

import com.company.heartbeatsignal.dto.Convertible;
import com.company.heartbeatsignal.entity.Vip;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Liquid
 * @类名： VipDTO
 * @描述：
 * @date 2019/5/11
 */
@Data
public class VipDTO implements Serializable {
    private static final long serialVersionUID = -650133911980800812L;

    /**
     * formId
     */
    private String formId;

    /**
     * id
     */
    private Integer id;

    /**
     * 关联用户id
     */
    private Integer userId;

    /**
     * 会员过期时间
     */
    private Date stopTime;

    private static VipConvert vipConvert;

    static {
        vipConvert = new VipConvert();
    }

    public Vip convertToVip() {
        return vipConvert.convertToDO(this);
    }

    public VipDTO convertToVipDTO(Vip vip) {
        return vipConvert.convertToDTO(vip);
    }

    public static class VipConvert implements Convertible<Vip, VipDTO> {

        @Override
        public Vip convertToDO(VipDTO vipDTO) {
            Vip vip = new Vip();
            BeanUtils.copyProperties(vipDTO, vip);
            return vip;
        }

        @Override
        public VipDTO convertToDTO(Vip vip) {
            VipDTO vipDTO = new VipDTO();
            BeanUtils.copyProperties(vip, vipDTO);
            return vipDTO;
        }
    }
}
