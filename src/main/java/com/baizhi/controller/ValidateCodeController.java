package com.baizhi.controller;

import com.baizhi.utils.MyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * val
 * Created by gjp06 on 17.6.12.
 */
@RequestMapping("/common")
@Controller("validateCodeController")
public class ValidateCodeController {

    @RequestMapping("/getValidateImg")
    @ResponseBody
    public void getValidateImg(HttpServletResponse response, HttpSession session) throws IOException {
        String randomCode = MyUtils.getRandomCode(4);
        session.setAttribute("vcode", randomCode);
        BufferedImage verifyImg = MyUtils.getVerifyImg(randomCode, 40, 90);
        ImageIO.write(verifyImg, "png", response.getOutputStream());
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }
}
