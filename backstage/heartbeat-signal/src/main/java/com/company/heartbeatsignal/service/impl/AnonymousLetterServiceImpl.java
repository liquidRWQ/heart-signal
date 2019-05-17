package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.AnonymousLetterMapper;
import com.company.heartbeatsignal.dto.entity.AnonymousLetterDTO;
import com.company.heartbeatsignal.entity.AnonymousLetter;
import com.company.heartbeatsignal.service.AnonymousLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liquid
 * @类名： AnonymousLetterServiceImpl
 * @描述：
 * @date 2019/5/8
 */
@Service("anonymousLetterServiceImpl")
public class AnonymousLetterServiceImpl implements AnonymousLetterService {

    @Autowired
    private AnonymousLetterMapper anonymousLetterMapper;

    @Override
    public void insert(AnonymousLetterDTO anonymousLetterDTO) {
        AnonymousLetter anonymousLetter = anonymousLetterDTO.convertToAnonymousLetter();
        anonymousLetter.setAllTime();
        anonymousLetterMapper.insert(anonymousLetter);
    }

    @Override
    public List<AnonymousLetterDTO> selectAll() {
        List<AnonymousLetter> anonymousLetters = anonymousLetterMapper.selectAll();
        List<AnonymousLetterDTO> anonymousLetterDTOs = new ArrayList<>();
        for (AnonymousLetter anonymousLetter : anonymousLetters) {
            anonymousLetterDTOs.add(new AnonymousLetterDTO().convertToAnonymousLetterDTO(anonymousLetter));
        }
        return anonymousLetterDTOs;
    }

    @Override
    public AnonymousLetterDTO selectByPrimary(AnonymousLetterDTO anonymousLetterDTO) {
        return new AnonymousLetterDTO().convertToAnonymousLetterDTO(anonymousLetterMapper.selectByPrimaryKey(anonymousLetterDTO.getId()));
    }

    @Override
    public void updateByPrimary(AnonymousLetterDTO anonymousLetterDTO) {
        AnonymousLetter anonymousLetter = anonymousLetterDTO.convertToAnonymousLetter();
        anonymousLetter.refreshLastUpdateTime();
        anonymousLetterMapper.updateByPrimaryKeySelective(anonymousLetter);
    }

    @Override
    public void deleteByPrimary(AnonymousLetterDTO anonymousLetterDTO) {
        anonymousLetterMapper.deleteByPrimaryKey(anonymousLetterDTO.getId());
    }

    @Override
    public List<AnonymousLetterDTO> selectBySenderId(AnonymousLetterDTO anonymousLetterDTO) {
        List<AnonymousLetter> anonymousLetters = anonymousLetterMapper.select(anonymousLetterDTO.convertToAnonymousLetter());
        ArrayList<AnonymousLetterDTO> anonymousLetterDTOS = new ArrayList<>();
        for (AnonymousLetter anonymousLetter : anonymousLetters) {
            anonymousLetterDTOS.add(new AnonymousLetterDTO().convertToAnonymousLetterDTO(anonymousLetter));
        }
        return anonymousLetterDTOS;
    }

    @Override
    public List<AnonymousLetterDTO> selectByReceiverId(AnonymousLetterDTO anonymousLetterDTO) {
        List<AnonymousLetter> anonymousLetters = anonymousLetterMapper.select(anonymousLetterDTO.convertToAnonymousLetter());
        ArrayList<AnonymousLetterDTO> anonymousLetterDTOS = new ArrayList<>();
        for (AnonymousLetter anonymousLetter : anonymousLetters) {
            anonymousLetterDTOS.add(new AnonymousLetterDTO().convertToAnonymousLetterDTO(anonymousLetter));
        }
        return anonymousLetterDTOS;
    }
}
