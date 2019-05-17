package com.company.heartbeatsignal.dto.entity;

import com.company.heartbeatsignal.dto.Convertible;
import com.company.heartbeatsignal.entity.Img;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： ImgDTO
 * @描述：
 * @date 2019/5/11
 */
@Data
public class ImgDTO implements Serializable {

    private static final long serialVersionUID = -6505495823183073460L;
    /**
     * formId
     */
    private String formId;

    /**
     * 图片id
     */
    private Integer id;

    /**
     * 图片名称
     */
    private String imgName;

    /**
     * 图片路径
     */
    private String imgPath;

    private static ImgConvert imgConvert;

    static {
        imgConvert = new ImgConvert();
    }

    public Img convertToImg() {

        return imgConvert.convertToDO(this);
    }

    public ImgDTO convertToImgDTO(Img img) {
        return imgConvert.convertToDTO(img);
    }

    public static class ImgConvert implements Convertible<Img, ImgDTO> {

        @Override
        public Img convertToDO(ImgDTO imgDTO) {
            Img img = new Img();
            BeanUtils.copyProperties(imgDTO, img);
            return img;
        }

        @Override
        public ImgDTO convertToDTO(Img img) {
            ImgDTO imgDTO = new ImgDTO();
            BeanUtils.copyProperties(img, imgDTO);
            return imgDTO;
        }
    }
}
