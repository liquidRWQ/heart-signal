package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.context.ramdomid.RandomIdContext;
import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.UserPhotoMapper;
import com.company.heartbeatsignal.dto.entity.UserPhotoDTO;
import com.company.heartbeatsignal.dto.other.FileDTO;
import com.company.heartbeatsignal.entity.UserPhoto;
import com.company.heartbeatsignal.service.UserPhotoService;
import com.company.heartbeatsignal.util.FileUpLoadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liquid
 * @类名： UserPhotoServiceImpl
 * @描述：
 * @date 2019/5/17
 */

@Slf4j
@Service("userPhotoServiceImpl")
public class UserPhotoServiceImpl implements UserPhotoService {

    private static final String FOLDER_NAME = "userPhoto";

    @Autowired
    private UserPhotoMapper userPhotoMapper;

    @Autowired
    private RandomIdContext randomIdContext;

    @Override
    public void insertUserPhoto(UserPhotoDTO userPhotoDTO, String realPath, MultipartFile file) {
        FileDTO fileDTO = new FileDTO();
        fileDTO.setFolderName(FOLDER_NAME);
        fileDTO.setMultipartFile(file);
        fileDTO.setRealPath(realPath);
        fileDTO.setSecondFolderName("user_" + userPhotoDTO.getUserId());
        fileDTO.setFileName(randomIdContext.getRandomId("uuid"));
        FileUpLoadUtils.setFileToServer(fileDTO);

        userPhotoDTO.setPhotoPath(fileDTO.getPath());
        userPhotoDTO.setPhotoName(fileDTO.getFileName());
        userPhotoDTO.setPhotoPath(fileDTO.getPath());
        UserPhoto userPhoto = userPhotoDTO.convertToUserPhoto();
        log.info(userPhoto.toString());
        userPhoto.setAllTime();
        userPhotoMapper.insert(userPhoto);

    }

    @Override
    public void deleteByPrimary(UserPhotoDTO userPhotoDTO) {
        String photoPath = userPhotoMapper.selectByPrimaryKey(userPhotoDTO.getId()).getPhotoPath();
        userPhotoMapper.deleteByPrimaryKey(userPhotoDTO.getId());
        FileDTO fileDTO = new FileDTO();
        fileDTO.setRealPath(photoPath);
        FileUpLoadUtils.deleteFile(fileDTO);
    }

    @Override
    public List<UserPhotoDTO> getUserPhoto(UserPhotoDTO userPhotoDTO) {
        List<UserPhoto> userPhotos = userPhotoMapper.select(userPhotoDTO.convertToUserPhoto());
        List<UserPhotoDTO> userPhotoDTOS = new ArrayList<>();
        for (UserPhoto userPhoto : userPhotos) {
            userPhotoDTOS.add(new UserPhotoDTO().convertToUserPhotoDTO(userPhoto));
        }

        return userPhotoDTOS;
    }

    @Override
    public void insert(UserPhotoDTO userPhotoDTO) {

    }

    @Override
    public List<UserPhotoDTO> selectAll() {
        return null;
    }

    @Override
    public UserPhotoDTO selectByPrimary(UserPhotoDTO userPhotoDTO) {
        return null;
    }

    @Override
    public void updateByPrimary(UserPhotoDTO userPhotoDTO) {

    }

}
