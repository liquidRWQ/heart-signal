package com.company.heartbeatsignal.util;

import com.company.heartbeatsignal.context.ramdomid.RandomIdContext;
import com.company.heartbeatsignal.dto.other.FileDTO;
import com.company.heartbeatsignal.enums.FileType;
import com.company.heartbeatsignal.exception.UnCheckedException;
import com.company.heartbeatsignal.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名： MyFileUtil
 *
 * @author Liquid
 * <p>
 * 描述： 文件上传类
 * @date 2018/12/27
 */
@Component
@Slf4j
public class FileUpAndDownUtils {

    @Autowired
    private static RandomIdContext randomIdContext;

    /**
     * @param
     * @param
     * @param ：将图片上传到服务器
     * @return java.lang.String
     * @author Liquid
     * @date 2018/12/27
     */
    public static List<String> setImgToServer(FileDTO fileDTO) {
        MultipartFile[] multipartFiles = fileDTO.getMultipartFiles();
        String folderName = fileDTO.getFolderName();
        String realPath = fileDTO.getRealPath();
        StringBuilder stringBuilder = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            String down = down(multipartFile, realPath, folderName, stringBuilder);
            list.add(down);
            stringBuilder.setLength(0);
        }

        return list;

    }

    private static String down(MultipartFile multipartFile, String realPath, String folderName, StringBuilder stringBuilder) {
        String fileName = multipartFile.getOriginalFilename();
        String fileType = StringUtils.substringAfterLast(fileName, ".");
        if (FileType.IMAGE.value().contains(fileType)) {
            // 自定义的文件名称
            String trueFileName = randomIdContext.getRondomId("uuid");
            // 设置存放图片文件的路径
            String path = stringBuilder.append(realPath).append("uploads/").append(folderName).toString();
            stringBuilder.setLength(0);
            File serverFile = new File(path);
            if (!serverFile.exists()) {
                if (!serverFile.mkdirs()) {
                    throw new UnCheckedException("上传图片异常: 创建空文件夹失败 ");
                }
            }
            String serverPath = stringBuilder.append(path).append("/").append(trueFileName).append(".").append(fileType).toString();
            log.info("图片绝地路径位置为：" + path);
            try {
                multipartFile.transferTo(new File(serverPath));
            } catch (IOException e) {
                throw new UnCheckedException("上传文件异常: " + e.toString());
            }
            return serverPath;
        } else {
            throw new UserException("不是我们想要的文件类型,请按要求重新上传");
        }
    }

    public static List<String> downloadFromServer(FileDTO fileDTO) {
        return null;
    }

}
