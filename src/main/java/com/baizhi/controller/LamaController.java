package com.baizhi.controller;

import com.baizhi.entity.*;
import com.baizhi.service.LamaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * controller
 * Created by gjp06 on 17.6.14.
 */
@Controller("lamaController")
@RequestMapping("/lama")
public class LamaController {

    @Resource(name = "lamaService")
    private LamaService service;

    @RequestMapping("/add")
    @ResponseBody
    public void add(Lama lama, MultipartFile uploadFile, HttpSession session) throws IOException {
        lama.setSrc(uploadFile.getOriginalFilename());
        String contextPath = session.getServletContext().getRealPath("/img/lamaImages");
        String path = contextPath + "\\" + uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File(path));
        System.out.println(lama);
        service.addLama(lama);
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public LamaDTO queryAll(Integer page, Integer rows) {
        Page p = new Page(page, rows);
        List<Lama> lamaList = service.queryAllLama(p);
        LamaDTO lamaDTO = new LamaDTO();
        lamaDTO.setTotal(p.getTotalRows());
        lamaDTO.setRows(lamaList);
        return lamaDTO;
    }

    @RequestMapping("/getList")
    @ResponseBody
    public List<Lama> getList() {
        return service.queryAllLama(new Page(1, 1000));
    }

    @RequestMapping("/queryOne")
    @ResponseBody
    public Lama queryOne(String id) {
        Lama lama = new Lama();
        lama.setId(id);
        return service.queryOneLama(lama);
    }

    @RequestMapping("/modify")
    @ResponseBody
    public void modify(Lama lama) {
        service.modifyLama(lama);
    }

}
