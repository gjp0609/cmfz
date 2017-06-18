package com.baizhi.advice;

import com.baizhi.entity.Admin;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gjp06 on 17.6.18.
 */
@Aspect
@Component
public class TestAdvice {

    @After(value = "execution(* com.baizhi.service.impl.SlideImageServiceImpl.addSlideImage(..))")
    public void after() {
        Admin admin = new Admin();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
