package com.company.heartbeatsignal.service;

import com.company.heartbeatsignal.dto.entity.ImgDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Liquid
 * @类名： ImgService
 * @描述：
 * @date 2019/5/8
 */
public interface ImgService {

    String uploadOneImg(String realPath, MultipartFile file);

    List<String> uploadManyImgs(String realPath,MultipartFile[] files);

    List<ImgDTO> getAllImgs();

    void deleteImg(ImgDTO imgDTO);
}
