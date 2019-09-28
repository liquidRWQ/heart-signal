package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.UserPhotoDTO;
import com.company.heartbeatsignal.vo.ResultVO;
import com.company.heartbeatsignal.service.UserPhotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Liquid
 * @类名： UserPhotoController
 * @描述：
 * @date 2019/5/17
 */
@Slf4j
@RestController
public class UserPhotoController {

    @Autowired
    private UserPhotoService userPhotoService;

    @PostMapping("/setUserPhoto")
    public ResultVO setUserPhoto(UserPhotoDTO userPhotoDTO, @RequestParam("file") MultipartFile file) {
        String realPath ="/usr/heart/";
        userPhotoService.insertUserPhoto(userPhotoDTO, realPath, file);
        return new ResultVO<>();
    }

    @GetMapping("/getUserPhotosByUserId")
    public ResultVO getUserPhotosByUserId(UserPhotoDTO userPhotoDTO) {
        return new ResultVO<>(userPhotoService.getUserPhoto(userPhotoDTO));
    }

    public ResultVO getOne(UserPhotoDTO userPhotoDTO) {
        return null;
    }

    public ResultVO getAll() {
        return null;
    }

    public ResultVO addOne(UserPhotoDTO userPhotoDTO) {
        return null;
    }

    public ResultVO updateOne(UserPhotoDTO userPhotoDTO) {
        return null;
    }

    @DeleteMapping("/deleteUserPhoto")
    public ResultVO deleteOne(UserPhotoDTO userPhotoDTO) {
        userPhotoService.deleteByPrimary(userPhotoDTO);
        return new ResultVO<>();
    }
}
