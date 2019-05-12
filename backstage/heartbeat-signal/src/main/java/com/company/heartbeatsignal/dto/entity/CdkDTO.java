package com.company.heartbeatsignal.dto.entity;

import com.company.heartbeatsignal.dto.Convertible;
import com.company.heartbeatsignal.entity.Cdk;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Liquid
 * @类名： CdkDTO
 * @描述：
 * @date 2019/5/11
 */
@Data
public class CdkDTO implements Serializable {

    private static final long serialVersionUID = -4057156499539492023L;
    /**
     * id
     */
    private Integer id;

    /**
     * 兑换码
     */
    private String cdk;

    /**
     * 兑换奖励
     */
    private String reward;

    /**
     * 兑换码过期时间
     */
    private Date stopTime;

    private static CdkConvert cdkConvert;

    static {
        cdkConvert = new CdkConvert();
    }

    public Cdk convertToCdk() {

        return cdkConvert.convertToDO(this);
    }

    public CdkDTO convertToCdkDTO(Cdk cdk) {
        return cdkConvert.convertToDTO(cdk);
    }

    public static class CdkConvert implements Convertible<Cdk, CdkDTO> {

        @Override
        public Cdk convertToDO(CdkDTO cdkDTO) {
            Cdk cdk = new Cdk();
            BeanUtils.copyProperties(cdkDTO, cdk);
            return cdk;
        }

        @Override
        public CdkDTO convertToDTO(Cdk cdk) {
            CdkDTO cdkDTO = new CdkDTO();
            BeanUtils.copyProperties(cdk, cdkDTO);
            return cdkDTO;
        }
    }
}
