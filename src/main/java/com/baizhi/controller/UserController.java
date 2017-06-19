package com.baizhi.controller;

import com.baizhi.entity.DataDTO;
import com.baizhi.entity.Page;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.utils.MyUtils;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * user
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


    @RequestMapping(value = "/loginChart", produces = "application/json")
    @ResponseBody
    public List<Integer> loginChart() {
        return service.getLoginChart();
    }

    @RequestMapping(value = "/mapChart", produces = "application/json")
    @ResponseBody
    public Map<String, List<Map<String, Object>>> mapChart() {
        Map<String, List<Map<String, Object>>> mapChart = service.getMapChart();
        return mapChart;
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

    @RequestMapping("/customExport")
    @ResponseBody
    public void customExport(String text, String[] values, HttpServletResponse response) {
        // 编号, 姓名, 真实姓名
        String[] strings = text.split(",");
        // id,username, realname
        try {
            HSSFWorkbook workbook = service.getCustomExcel(strings, values);
            response.setHeader("content-disposition", "attachment;filename="
                    + URLEncoder.encode("用户信息", "utf-8") + MyUtils.fmtDate(new Date())
                    + ".xls");
            response.setContentType("application/vnd.ms-excel");
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/getModel")
    @ResponseBody
    public void getModel(HttpSession session, HttpServletResponse response) {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(
                    new FileInputStream(session.getServletContext().getRealPath("\\file\\model.xls")));
            response.setHeader("content-disposition", "attachment;filename="
                    + URLEncoder.encode("用户信息", "utf-8") + MyUtils.fmtDate(new Date())
                    + ".xls");
            response.setContentType("application/vnd.ms-excel");
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/importData")
    @ResponseBody
    public void importData(MultipartFile uploadFile) {
        try {
            InputStream inputStream = uploadFile.getInputStream();
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            service.importData(workbook);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
