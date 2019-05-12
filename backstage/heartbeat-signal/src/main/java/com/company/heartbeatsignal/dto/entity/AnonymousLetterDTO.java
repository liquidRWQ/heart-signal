package com.company.heartbeatsignal.dto.entity;

import com.company.heartbeatsignal.dto.Convertible;
import com.company.heartbeatsignal.entity.AnonymousLetter;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/5/8
 */
@Data
public class AnonymousLetterDTO implements Serializable {

    private static final long serialVersionUID = -7765247949839045385L;
    /**
     * id
     */

    private Integer id;

    /**
     * 匿名信发送者id
     */
    private Integer senderId;

    /**
     * 匿名信接受者id
     */
    private Integer receiverId;

    /**
     * 匿名信内容
     */
    private String info;

    private static AnonymousLetterConvert anonymousLetterConvert;

    static {
        anonymousLetterConvert = new AnonymousLetterConvert();
    }

    public AnonymousLetter convertToAnonymousLetter() {
        return anonymousLetterConvert.convertToDO(this);
    }

    public AnonymousLetterDTO convertToAnonymousLetterDTO(AnonymousLetter anonymousLetter) {
        return anonymousLetterConvert.convertToDTO(anonymousLetter);
    }

    public static class AnonymousLetterConvert implements Convertible<AnonymousLetter, AnonymousLetterDTO> {

        @Override
        public AnonymousLetter convertToDO(AnonymousLetterDTO anonymousLetterDTO) {
            AnonymousLetter anonymousLetter = new AnonymousLetter();
            BeanUtils.copyProperties(anonymousLetterDTO, anonymousLetter);
            return anonymousLetter;
        }

        @Override
        public AnonymousLetterDTO convertToDTO(AnonymousLetter anonymousLetter) {
            AnonymousLetterDTO anonymousLetterDTO = new AnonymousLetterDTO();
            BeanUtils.copyProperties(anonymousLetter, anonymousLetterDTO);
            return anonymousLetterDTO;
        }
    }

}