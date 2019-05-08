package com.company.heartbeatsignal.aop;

import com.company.heartbeatsignal.exception.CheckedException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @className BindingResultAop
 * @auther Liquid
 * @description
 * @date 2018/12/24
 */
@Order(2)
@Component
@Aspect
@Slf4j
public class BindingResultAop {

    @Pointcut("execution(public com.company.heartbeatsignal.result.ResultBean *(..))")
    public void resultBean() {
    }

    @Around("resultBean()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        BindingResult bindingResult = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof BindingResult) {
                bindingResult = (BindingResult) arg;
            }

        }
        if (bindingResult != null) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            if (errors.size() > 0) {
                StringBuilder msg = new StringBuilder();
                msg.append("参数出错: ");
                for (ObjectError error : errors) {
                    Object[] arguments = error.getArguments();
                    String string = arguments[0].toString();
                    int start = string.indexOf("[");
                    int end = string.indexOf(",");
                    msg.append(string.substring(start + 1, end))
                            .append(" ")
                            .append(error.getDefaultMessage())
                            .append("\t");

                }
                throw new CheckedException(msg.toString());
            }
        }
        return joinPoint.proceed();
    }

}
