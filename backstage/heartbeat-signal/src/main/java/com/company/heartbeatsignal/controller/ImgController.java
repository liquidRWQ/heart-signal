package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.vo.ResultVO;
import com.company.heartbeatsignal.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Liquid
 * @类名： ImgController
 * @描述：
 * @date 2019/5/8
 */
@RestController
public class ImgController {


    @Autowired
    private ImgService imgService;

    /**
     * @param
     * @return
     * @throws
     * @author Liquid
     * @描述：
     * @date 2019/5/15
     */
    @PostMapping("/uploadOne")
    public ResultVO uploadOne(HttpServletRequest httpServletRequest, @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {

        String realPath ="/usr/heart/";
        String serverPath = imgService.uploadOneImg(realPath, file);
        return new ResultVO<String>(serverPath);

    }

    @PostMapping("/uploadMany")
    public ResultVO uploadMany(HttpServletRequest httpServletRequest, @RequestParam(value = "files", required = false) MultipartFile[] files) throws Exception {

        String realPath ="/usr/heart/";
        List<String> serverPath = imgService.uploadManyImgs(realPath, files);
        return new ResultVO<List<String>>(serverPath);

    }

    /**
     * @param
     * @return
     * @throws null
     * @author Liquid
     * @描述：
     * @date 2019/5/15
     */
    @PostMapping("/downLoad")
    public ResultVO downLoad(HttpServletRequest httpServletRequest, @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {

        String realPath = httpServletRequest.getSession().getServletContext().getRealPath("/");
        String serverPath = null;
        return new ResultVO<String>(serverPath);

    }


}
