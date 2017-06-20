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
 * admin controller 1
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

    @RequestMapping("/queryOne")
    @ResponseBody
    public Admin queryOne(HttpSession session) {
        Object o = session.getAttribute("admin");
        Admin admin = (Admin) o;
        return service.queryOne(admin);
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("admin");
        return "redirect:/login.jsp";
    }

    @RequestMapping(value = "/changePassword", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String changePassword(Admin admin, String oldPassword) {
        String message = "修改失败";
        if (admin != null && admin.getUsername() != null) {
            try {
                service.modifyAdmin(admin, oldPassword);
            } catch (Exception e) {
                message = e.getMessage();
                System.out.println(message);
                return message;
            }
            return "修改成功";
        }
        return message;
    }

}
