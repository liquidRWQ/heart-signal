package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.result.ResultBean;
import com.company.heartbeatsignal.service.FileService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

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

    @GetMapping("/{foldname}/{filename:.+}")
    public ResponseEntity<?> getFile(@PathVariable String foldname, @PathVariable String filename, HttpServletRequest httpServletRequest) {

        String realPath = httpServletRequest.getSession().getServletContext().getRealPath("/")+"files/"+foldname+"/"+filename;
        File file=new File(realPath);
        try {
            return ResponseEntity.ok(FileUtils.readFileToByteArray(file));
        } catch (Exception e) {
            //404
            return ResponseEntity.notFound().build();
        }
    }
}
