package com.company.heartbeatsignal.service;

import com.company.heartbeatsignal.dto.entity.AnonymousLetterDTO;
import com.company.heartbeatsignal.service.infc.Cruder;

import java.util.List;

/**
 * @author Liquid
 * @类名： AnonymousLetterService
 * @描述：
 * @date 2019/5/8
 */
public interface AnonymousLetterService extends Cruder<AnonymousLetterDTO>{
    List<AnonymousLetterDTO> selectBySenderId(AnonymousLetterDTO anonymousLetterDTO);

    List<AnonymousLetterDTO> selectByReceiverId(AnonymousLetterDTO anonymousLetterDTO);
}
