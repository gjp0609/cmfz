package com.baizhi.controller;

import com.baizhi.entity.DataDTO;
import com.baizhi.entity.Page;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gjp06 on 17.6.16.
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private UserService service;

    @RequestMapping("/queryOne")
    @ResponseBody
    public User queryOne(String id) {
        System.out.println(id);
        User user = new User();
        user.setId(id);
        return service.queryOneUser(user);
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public DataDTO<User> queryAll(Integer page, Integer rows) {
        Page p = new Page(page, rows);
        List<User> userList = service.queryAllUser(p);
        DataDTO<User> userDataDTO = new DataDTO<User>();
        userDataDTO.setTotal(p.getTotalRows());
        userDataDTO.setRows(userList);
        return userDataDTO;
    }

    @RequestMapping("/modify")
    @ResponseBody
    public void modify(User user) {
        service.modifyUser(user);
    }

}
