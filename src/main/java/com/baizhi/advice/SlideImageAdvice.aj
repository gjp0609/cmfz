package com.baizhi.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by gjp06 on 17.6.18.
 */

@Aspect
@Component
public aspect SlideImageAdvice {

    @Before("execution(* com.baizhi.service.impl.SlideImageServiceImpl.addSlideImage(..))")
    public void add() {
        System.out.println("add");
    }
}
