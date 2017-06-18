package com.baizhi.controller;

import com.baizhi.entity.DataDTO;
import com.baizhi.entity.Page;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
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


    @RequestMapping(value = "/chart1", produces = "application/json")
    @ResponseBody
    public List<Integer> chart1() {
        return service.getChart1();
    }

    @RequestMapping("/getAllData")
    public ResponseEntity<byte[]> getAllData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HSSFWorkbook allDataExcel = service.getAllDataExcel();
        File file = new File("1.xls");
        System.out.println(file.getAbsolutePath());
        allDataExcel.write(file);
        allDataExcel.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/vnd.ms-excel"));
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}
