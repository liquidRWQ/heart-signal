package com.company.heartbeatsignal.dto.entity;

import com.company.heartbeatsignal.dto.Convertible;
import com.company.heartbeatsignal.entity.UserPhoto;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： UserPhotoDTO
 * @描述：
 * @date 2019/5/17
 */
@Data
public class UserPhotoDTO implements Serializable {

    private static final long serialVersionUID = -4204252808457421631L;

    /**
     * id
     */

    private Integer id;

    /**
     * 关联userId
     */

    private Integer userId;

    /**
     * 图片名称
     */
    private String photoName;

    /**
     * 图片地址
     */
    private String photoPath;

    private static UserPhotoConvert userPhotoConvert;

    static {
        userPhotoConvert = new UserPhotoConvert();
    }

    public UserPhoto convertToUserPhoto() {
        return userPhotoConvert.convertToDO(this);
    }

    public UserPhotoDTO convertToUserPhotoDTO(UserPhoto userPhoto) {
        return userPhotoConvert.convertToDTO(userPhoto);
    }

    public static class UserPhotoConvert implements Convertible<UserPhoto, UserPhotoDTO> {

        @Override
        public UserPhoto convertToDO(UserPhotoDTO userPhotoDTO) {
            UserPhoto userPhoto = new UserPhoto();
            BeanUtils.copyProperties(userPhotoDTO, userPhoto);
            return userPhoto;
        }

        @Override
        public UserPhotoDTO convertToDTO(UserPhoto userPhoto) {
            UserPhotoDTO userPhotoDTO = new UserPhotoDTO();
            BeanUtils.copyProperties(userPhoto, userPhotoDTO);
            return userPhotoDTO;
        }
    }
}
