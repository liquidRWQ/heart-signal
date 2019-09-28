package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.AnonymousLetterDTO;
import com.company.heartbeatsignal.vo.ResultVO;
import com.company.heartbeatsignal.service.AnonymousLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Liquid
 * @类名： AnonymousLetterController
 * @描述：
 * @date 2019/5/8
 */
@RestController
public class AnonymousLetterController  {

    @Autowired
    private AnonymousLetterService anonymousLetterService;

    @GetMapping("/getAnonymousLetter")
    public ResultVO getOne(AnonymousLetterDTO anonymousLetterDTO) {
        return new ResultVO<>(anonymousLetterService.selectByPrimary(anonymousLetterDTO));
    }

    @GetMapping("/getAnonymousLetters")
    public ResultVO getAll() {
        return new ResultVO<>(anonymousLetterService.selectAll());
    }

    @PostMapping("/addAnonymousLetter")
    public ResultVO addOne(AnonymousLetterDTO anonymousLetterDTO) throws Exception {
        anonymousLetterService.insert(anonymousLetterDTO);
        return new ResultVO<>();
    }

    @PutMapping("/updateAnonymousLetter")
    public ResultVO updateOne(AnonymousLetterDTO anonymousLetterDTO) {
        anonymousLetterService.updateByPrimary(anonymousLetterDTO);
        return new ResultVO<>();
    }

    @DeleteMapping("/deleteAnonymousLetter")
    public ResultVO deleteOne(AnonymousLetterDTO anonymousLetterDTO) {
        anonymousLetterService.deleteByPrimary(anonymousLetterDTO);
        return new ResultVO<>();
    }

    @GetMapping("/getAnonymousLetterBySenderId")
    public ResultVO getAnonymousLetterBySenderId(AnonymousLetterDTO anonymousLetterDTO) {
        return new ResultVO<>(anonymousLetterService.selectBySenderId(anonymousLetterDTO));
    }

    @GetMapping("/getAnonymousLetterByReceiverId")
    public ResultVO getAnonymousLetterByReceiverId(AnonymousLetterDTO anonymousLetterDTO) {
        return new ResultVO<>(anonymousLetterService.selectByReceiverId(anonymousLetterDTO));
    }

}
