package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.UserPhotoDTO;
import com.company.heartbeatsignal.result.ResultBean;
import com.company.heartbeatsignal.service.UserPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Liquid
 * @类名： UserPhotoController
 * @描述：
 * @date 2019/5/17
 */

@RestController
public class UserPhotoController {

    @Autowired
    private UserPhotoService userPhotoService;

    @PostMapping("/setUserPhoto")
    public ResultBean setUserPhoto(UserPhotoDTO userPhotoDTO, @RequestParam("files") MultipartFile[] files, HttpServletRequest httpServletRequest) {
        String realPath = httpServletRequest.getSession().getServletContext().getRealPath("/");
        userPhotoService.insertUserPhoto(userPhotoDTO, realPath, files);
        return new ResultBean<>();
    }

    @GetMapping("/getUserPhotosByUserId")
    public ResultBean getUserPhotos(UserPhotoDTO userPhotoDTO) {
        userPhotoService.getUserPhoto(userPhotoDTO);
        return new ResultBean<>();
    }


    public ResultBean getOne(UserPhotoDTO userPhotoDTO) {
        return null;
    }


    public ResultBean getAll() {
        return null;
    }


    public ResultBean addOne(UserPhotoDTO userPhotoDTO) {
        return null;
    }


    public ResultBean updateOne(UserPhotoDTO userPhotoDTO) {
        return null;
    }

    @DeleteMapping("/deleteUserPhoto")
    public ResultBean deleteOne(UserPhotoDTO userPhotoDTO) {
        userPhotoService.deleteByPrimary(userPhotoDTO);
        return new ResultBean<>();
    }
}
