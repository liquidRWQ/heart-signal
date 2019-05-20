package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.controller.infc.Cruder;
import com.company.heartbeatsignal.dto.entity.AnonymousLetterDTO;
import com.company.heartbeatsignal.result.ResultBean;
import com.company.heartbeatsignal.service.AnonymousLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Liquid
 * @类名： AnonymousLetterController
 * @描述：
 * @date 2019/5/8
 */
@RequestMapping("/anonymous")
@RestController
public class AnonymousLetterController implements Cruder<AnonymousLetterDTO> {

    @Autowired
    private AnonymousLetterService anonymousLetterService;

    @GetMapping("/getAnonymousLetter")
    @Override
    public ResultBean getOne(AnonymousLetterDTO anonymousLetterDTO) {
        return new ResultBean<>(anonymousLetterService.selectByPrimary(anonymousLetterDTO));
    }

    @GetMapping("/getAnonymousLetters")
    @Override
    public ResultBean getAll() {
        return new ResultBean<>(anonymousLetterService.selectAll());
    }

    @PostMapping("/addAnonymousLetter")
    @Override
    public ResultBean addOne(AnonymousLetterDTO anonymousLetterDTO) throws Exception {
        anonymousLetterService.insert(anonymousLetterDTO);
        return new ResultBean<>();
    }

    @PutMapping("/updateAnonymousLetter")
    @Override
    public ResultBean updateOne(AnonymousLetterDTO anonymousLetterDTO) {
        anonymousLetterService.updateByPrimary(anonymousLetterDTO);
        return new ResultBean<>();
    }

    @DeleteMapping("/deleteAnonymousLetter")
    @Override
    public ResultBean deleteOne(AnonymousLetterDTO anonymousLetterDTO) {
        anonymousLetterService.deleteByPrimary(anonymousLetterDTO);
        return new ResultBean<>();
    }

    @GetMapping("/getAnonymousLetterBySenderId")
    public ResultBean getAnonymousLetterBySenderId(AnonymousLetterDTO anonymousLetterDTO) {
        return new ResultBean<>(anonymousLetterService.selectBySenderId(anonymousLetterDTO));
    }

    @GetMapping("/getAnonymousLetterByReceiverId")
    public ResultBean getAnonymousLetterByReceiverId(AnonymousLetterDTO anonymousLetterDTO) {
        return new ResultBean<>(anonymousLetterService.selectByReceiverId(anonymousLetterDTO));
    }

}
