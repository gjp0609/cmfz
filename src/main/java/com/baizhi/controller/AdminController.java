package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * admin controller
 * Created by gjp06 on 17.6.12.
 */
@Controller("adminController")
@RequestMapping("/admin")
public class AdminController {

    @Resource(name = "adminService")
    private AdminService service;

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(String enCode, Admin admin, boolean remember, HttpSession session, HttpServletResponse response) throws UnsupportedEncodingException {
        String msg = "true";
        Admin dbAdmin = null;
        try {
            if (!enCode.equalsIgnoreCase((String) session.getAttribute("vcode")))
                throw new RuntimeException("validate code is incorrect");
            dbAdmin = service.queryAdmin(admin);
            // save username in cookie
            if (remember) {
                String username = admin.getUsername();
                // encode username
                String encode = URLEncoder.encode(username, "UTF-8");
                Cookie cookie = new Cookie("username", encode);
                cookie.setPath("/");
                cookie.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(cookie);
            }
            // save admin in session
            session.setAttribute("admin", dbAdmin);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        return msg;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("admin");
        return "redirect:/login.jsp";
    }

}
