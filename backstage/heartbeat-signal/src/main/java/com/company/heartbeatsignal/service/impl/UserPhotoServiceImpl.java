package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.UserPhotoMapper;
import com.company.heartbeatsignal.dto.entity.UserPhotoDTO;
import com.company.heartbeatsignal.dto.other.FileDTO;
import com.company.heartbeatsignal.dto.other.FilesDTO;
import com.company.heartbeatsignal.entity.UserPhoto;
import com.company.heartbeatsignal.service.UserPhotoService;
import com.company.heartbeatsignal.util.FileUpLoadUtils;
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
@Service("userPhotoServiceImpl")
public class UserPhotoServiceImpl implements UserPhotoService {

    private static final String FOLDER_NAME = "userphoto";

    @Autowired
    private UserPhotoMapper userPhotoMapper;

    @Override
    public void insertUserPhoto(UserPhotoDTO userPhotoDTO, String realPath, MultipartFile[] files) {
        FilesDTO filesDTO = new FilesDTO();
        filesDTO.setFolderName(FOLDER_NAME);
        filesDTO.setMultipartFiles(files);
        filesDTO.setRealPath(realPath);
        FileUpLoadUtils.setFilesToServer(filesDTO);
        List<String> paths = filesDTO.getPaths();
        List<String> fileNames = filesDTO.getFileNames();
        UserPhotoDTO userPhotoDTO1 = new UserPhotoDTO();
        UserPhoto userPhoto;
        for (int i = 0, length = files.length; i < length; i++) {
            userPhotoDTO1.setPhotoPath(paths.get(i));
            userPhotoDTO1.setPhotoName(fileNames.get(i));
            userPhoto = userPhotoDTO1.convertToUserPhoto();
            userPhoto.setAllTime();
            userPhotoMapper.insert(userPhoto);
        }

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
