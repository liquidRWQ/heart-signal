package com.company.heartbeatsignal.aop;

import com.company.heartbeatsignal.exception.CheckedException;
import com.company.heartbeatsignal.exception.UnCheckedException;
import com.company.heartbeatsignal.exception.UserException;
import com.company.heartbeatsignal.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @className ControllerAOP
 * @auther Liquid
 * @description
 * @date 2018/11/11
 */
@Order(1)
@Component
@Aspect
@Slf4j
public class LogAndExceptionAop {

    @Pointcut("execution(public com.company.heartbeatsignal.vo.ResultVO *(..))")
    public void resultBean() {
    }

    @Around("resultBean()")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();
        ResultVO<?> result;
        try {
            result = (ResultVO<?>) pjp.proceed();
            log.info("[当前线程: {}]   [切点: {}]  [方法运行时间: {}ms]", Thread.currentThread().getName(), pjp.getSignature(), (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }

        return result;
    }

    private ResultVO<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultVO<?> result = new ResultVO();
        // 已知异常 code=1,2,3
        if (e instanceof UserException) {
            result.setMsg(e.toString());
            result.setCode(ResultVO.USER_FAIL);
            log.warn("发生用户异常！{ 当前线程: {}] [切点: {}][异常信息: {} }", Thread.currentThread().getName(), pjp.getSignature(), e.toString());
        } else if (e instanceof UnCheckedException) {
            result.setMsg(e.toString());
            result.setCode(ResultVO.UNCHECKED_EXCEPTION_FAIL);
            log.error("发生不受检异常！{ 当前线程: {}] [切点: {}][异常信息: {} }", Thread.currentThread().getName(), pjp.getSignature(), e.toString());
        } else if (e instanceof CheckedException) {
            log.warn("发生受检异常！{ 当前线程: {}] [切点: {}][异常信息: {} }", Thread.currentThread().getName(), pjp.getSignature(), e.toString());
            result.setMsg(e.toString());
            result.setCode(ResultVO.CHECKED_EXCEPTION_FAIL);
        } else {
            log.error("发生未知异常！{ 当前线程: {}]  [切点: {}]  [异常信息: {}-{} }", Thread.currentThread().getName(), pjp.getSignature(), e.toString(), e.getLocalizedMessage());
            // 未知的异常，应该格外注意，可以发送邮件通知等 code=4
            result.setMsg(e.toString());
            result.setCode(ResultVO.UNKNOWN_EXCEPTION_FAIL);
        }

        return result;
    }
}
