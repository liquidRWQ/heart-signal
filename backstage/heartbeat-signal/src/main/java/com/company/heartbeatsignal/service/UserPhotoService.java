package com.company.heartbeatsignal.service;

import com.company.heartbeatsignal.dto.entity.UserPhotoDTO;
import com.company.heartbeatsignal.service.infc.Cruder;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Liquid
 * @类名： UserPhotoService
 * @描述：
 * @date 2019/5/17
 */
public interface UserPhotoService extends Cruder<UserPhotoDTO>{
    void insertUserPhoto(UserPhotoDTO userPhotoDTO, String realPath, MultipartFile file);




    List<UserPhotoDTO> getUserPhoto(UserPhotoDTO userPhotoDTO);
}
