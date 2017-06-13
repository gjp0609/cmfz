package com.baizhi.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gjp06 on 17.6.13.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final String[] IGNORE_URI = {"/login.jsp", "/common", "/login", "/img/","/logout"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        String url = request.getRequestURL().toString();
        System.out.println("url >> " + url);
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                System.out.println("to login");
                break;
            }
        }
        // is not login request
        if (!flag) {
            System.out.println("not to login");
            Object o = request.getSession().getAttribute("admin");
            // status is login
            if (o != null)
                flag = true;
        }
        System.out.println(flag);
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

}
