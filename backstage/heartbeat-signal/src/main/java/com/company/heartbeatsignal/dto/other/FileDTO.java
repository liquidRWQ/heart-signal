package com.company.heartbeatsignal.dto.other;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Liquid
 * @类名： FileDTO
 * @描述：
 * @date 2019/4/18
 */
@Data
public class FileDTO {
    String realPath;

    MultipartFile[] multipartFiles;

    String folderName;
}
