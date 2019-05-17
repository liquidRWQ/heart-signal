package com.company.heartbeatsignal.dto.entity;

import com.company.heartbeatsignal.dto.Convertible;
import com.company.heartbeatsignal.entity.VipOrder;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Liquid
 * @类名： VipOrderDTO
 * @描述：
 * @date 2019/5/17
 */
@Data
public class VipOrderDTO implements Serializable {
    private static final long serialVersionUID = -2779399689509429851L;

    /**
     * formId
     */
    private String formId;

    /**
     * id
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 关联用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 订单金额
     */
    @Column(name = "order_price")
    private Double orderPrice;

    /**
     * 订单完成时间
     */
    @Column(name = "order_time")
    private Date orderTime;

    private static VipOrderConvert vipOrderConvert;

    static {
        vipOrderConvert = new VipOrderConvert();
    }

    public VipOrder convertToVipOrder() {
        return vipOrderConvert.convertToDO(this);
    }

    public VipOrderDTO convertToVipOrderDTO(VipOrder vipOrder) {
        return vipOrderConvert.convertToDTO(vipOrder);
    }

    public static class VipOrderConvert implements Convertible<VipOrder, VipOrderDTO> {

        @Override
        public VipOrder convertToDO(VipOrderDTO vipOrderDTO) {
            VipOrder vipOrder = new VipOrder();
            BeanUtils.copyProperties(vipOrderDTO, vipOrder);
            return vipOrder;
        }

        @Override
        public VipOrderDTO convertToDTO(VipOrder vipOrder) {
            VipOrderDTO vipOrderDTO = new VipOrderDTO();
            BeanUtils.copyProperties(vipOrder, vipOrderDTO);
            return vipOrderDTO;
        }
    }
}
