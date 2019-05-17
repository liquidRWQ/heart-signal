package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.ImgMapper;
import com.company.heartbeatsignal.dto.entity.ImgDTO;
import com.company.heartbeatsignal.dto.other.FileDTO;
import com.company.heartbeatsignal.dto.other.FilesDTO;
import com.company.heartbeatsignal.entity.Img;
import com.company.heartbeatsignal.service.ImgService;
import com.company.heartbeatsignal.util.FileUpLoadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liquid
 * @类名： ImgServiceImpl
 * @描述：
 * @date 2019/5/8
 */
@Service("imgServiceImpl")
public class ImgServiceImpl implements ImgService {

    @Autowired
    private ImgMapper imgMapper;

    @Override
    public String uploadOneImg(String realPath, MultipartFile file) {
        FileDTO fileDTO = new FileDTO();
        fileDTO.setMultipartFile(file);
        fileDTO.setRealPath(realPath);
        fileDTO.setFolderName("imgs");
        ImgDTO imgDTO = new ImgDTO();
        FileUpLoadUtils.setFileToServer(fileDTO);
        imgDTO.setImgPath(fileDTO.getPath());
        imgDTO.setImgName(fileDTO.getFileName());
        Img img = imgDTO.convertToImg();
        img.setAllTime();
        imgMapper.insert(img);
        return fileDTO.getPath();
    }

    @Override
    public List<String> uploadManyImgs(String realPath, MultipartFile[] files) {
        FilesDTO filesDTO = new FilesDTO();
        filesDTO.setMultipartFiles(files);
        filesDTO.setRealPath(realPath);
        filesDTO.setFolderName("imgs");
        FileUpLoadUtils.setFilesToServer(filesDTO);
        List<String> paths = filesDTO.getPaths();
        List<String> fileNames = filesDTO.getFileNames();
        ImgDTO imgDTO = new ImgDTO();
        for (int i = 0, length = files.length; i < length; i++) {
            imgDTO.setImgPath(paths.get(i));
            imgDTO.setImgName(fileNames.get(i));
            Img img = imgDTO.convertToImg();
            img.setAllTime();
            imgMapper.insert(img);
        }
        return paths;
    }

    @Override
    public List<ImgDTO> getAllImgs() {
        List<Img> imgs = imgMapper.selectAll();
        List<ImgDTO> imgDTOS = new ArrayList<>();
        for (Img img : imgs) {
            imgDTOS.add(new ImgDTO().convertToImgDTO(img));
        }
        return imgDTOS;
    }

    @Override
    public void deleteImg(ImgDTO imgDTO) {
        Img img = imgMapper.selectByPrimaryKey(imgDTO.getId());
        imgMapper.deleteByPrimaryKey(imgDTO.getId());
        FileDTO fileDTO = new FileDTO();
        fileDTO.setRealPath(img.getImgPath());
        FileUpLoadUtils.deleteFile(fileDTO);
    }
}
