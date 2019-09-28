package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.vo.ResultVO;
import com.company.heartbeatsignal.service.FileService;
import lombok.extern.slf4j.Slf4j;
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
 * @描述： 这个不用CRUD
 * @date 2019/4/18
 */
@Slf4j
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
    public ResultVO uploadToFeedback(HttpServletRequest httpServletRequest, @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {

        String realPath = httpServletRequest.getSession().getServletContext().getRealPath("/");
        String serverPath = null;
        return new ResultVO<String>(serverPath);

    }

    /**
     * @param
     * @auther Liquid
     * @description
     * @date 2018/11/22
     */
    @PostMapping("/xx")
    public ResultVO downLoad(HttpServletRequest httpServletRequest, @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {

        String realPath = httpServletRequest.getSession().getServletContext().getRealPath("/");
        String serverPath = null;
        return new ResultVO<String>(serverPath);

    }

    @GetMapping("/files/{foldname}/{secondname}/{filename:.+}")
    public ResponseEntity<?> getFile(@PathVariable String foldname, @PathVariable String filename, @PathVariable String secondname) {
        String realPath = "/usr/heart/files/" + foldname + "/" + secondname + "/" + filename;
        log.info(realPath);
        File file = new File(realPath);
        try {
            return ResponseEntity.ok(FileUtils.readFileToByteArray(file));
        } catch (Exception e) {
            //404
            return ResponseEntity.notFound().build();
        }
    }



}
