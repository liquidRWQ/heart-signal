package com.company.heartbeatsignal.util;

import com.company.heartbeatsignal.dto.other.FileDTO;
import com.company.heartbeatsignal.dto.other.FilesDTO;
import com.company.heartbeatsignal.enums.FileType;
import com.company.heartbeatsignal.exception.UnCheckedException;
import com.company.heartbeatsignal.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
public class FileUpLoadUtils {

    /**
     * @param
     * @param
     * @param ：将图片上传到服务器
     * @return java.lang.String
     * @author Liquid
     * @date 2018/12/27
     */
    public static void setFileToServer(FileDTO fileDTO) {
        StringBuilder stringBuilder = new StringBuilder();
        down(fileDTO, stringBuilder);
    }

    /**
     * @param
     * @param
     * @param ：将图片上传到服务器
     * @return java.lang.String
     * @author Liquid
     * @date 2018/12/27
     */
    public static void setFilesToServer(FilesDTO filesDTO) {
        MultipartFile[] multipartFiles = filesDTO.getMultipartFiles();
        StringBuilder stringBuilder = new StringBuilder();
        List<String> paths = new ArrayList<>();
        List<String> fileNames = new ArrayList<>();
        FileDTO fileDTO = new FileDTO();
        fileDTO.setRealPath(filesDTO.getRealPath());
        fileDTO.setFolderName(filesDTO.getFolderName());
        fileDTO.setSecondFolderName(filesDTO.getSecondFolderName());
        for (MultipartFile multipartFile : multipartFiles) {
            fileDTO.setMultipartFile(multipartFile);
            fileDTO.setFileName(IdUtils.getUUID());
            down(fileDTO, stringBuilder);
            paths.add(fileDTO.getPath());
            fileNames.add(fileDTO.getFileName());
            stringBuilder.setLength(0);
        }
        filesDTO.setPaths(paths);
        filesDTO.setFileNames(fileNames);

    }

    private static void down(FileDTO fileDTO, StringBuilder stringBuilder) {
        String folderName = fileDTO.getFolderName();
        String secondFolderName = fileDTO.getSecondFolderName();
        String realPath = fileDTO.getRealPath();
        MultipartFile multipartFile = fileDTO.getMultipartFile();
        String trueFileName = fileDTO.getFileName();
        String originalFilename = multipartFile.getOriginalFilename();
        String fileType = StringUtils.substringAfterLast(originalFilename, ".");
        if (FileType.IMAGE.value().contains(fileType)) {
            // 自定义的文件名称
            // 设置存放文件的路径
            String path;
            if (secondFolderName != null) {
                path = stringBuilder.append(realPath).append("files/").append(folderName).append("/").append(secondFolderName).toString();
            } else {
                path = stringBuilder.append(realPath).append("files/").append(folderName).toString();
            }

            File serverFile = new File(path);
            if (!serverFile.exists()) {
                if (!serverFile.mkdirs()) {
                    throw new UnCheckedException("上传文件异常: 创建空文件夹失败 ");
                }
            }
            String serverPath = stringBuilder.append("/").append(trueFileName).append(".").append(fileType).toString();
            log.info("文件绝地路径位置为：" + path);
            try {
                multipartFile.transferTo(new File(serverPath));
            } catch (IOException e) {
                throw new UnCheckedException("上传文件异常: " + e.toString());
            }
        } else {
            throw new UserException("不是我们想要的文件类型,请按要求重新上传");
        }
    }

    public static void deleteFile(FileDTO fileDTO) {
        File file = new File(fileDTO.getRealPath());
        if (file.exists()) {
            if (!file.delete()) {
                throw new UnCheckedException("文件删除失败");
            }
        }
    }

}
