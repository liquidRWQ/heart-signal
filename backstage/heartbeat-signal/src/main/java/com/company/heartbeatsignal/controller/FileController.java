package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.result.ResultBean;
import com.company.heartbeatsignal.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Liquid
 * @类名： FileController
 * @描述：                  这个不用CRUD
 * @date 2019/4/18
 */
@RestController
public class FileController {

    @Autowired
    private FileService fileService;


    /**
     * @param
     * @auther Liquid
     * @description
     * @date 2018/11/22
     */
    @PostMapping("/index.html")
    public ResultBean uploadToFeedback(HttpServletRequest httpServletRequest, @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {

        String realPath = httpServletRequest.getSession().getServletContext().getRealPath("/");
        String serverPath = null;
        return new ResultBean<String>(serverPath);

    }

    /**
     * @param
     * @auther Liquid
     * @description
     * @date 2018/11/22
     */
    @PostMapping("/")
    public ResultBean downLoad(HttpServletRequest httpServletRequest, @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {

        String realPath = httpServletRequest.getSession().getServletContext().getRealPath("/");
        String serverPath = null;
        return new ResultBean<String>(serverPath);

    }
}
