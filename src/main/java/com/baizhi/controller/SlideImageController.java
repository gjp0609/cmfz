package com.baizhi.controller;

import com.baizhi.entity.DataDTO;
import com.baizhi.entity.Page;
import com.baizhi.entity.SlideImage;
import com.baizhi.service.SlideImageService;
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
 * Created by gjp06 on 17.6.13.
 */
@Controller("slideImageController")
@RequestMapping("/sli")
public class SlideImageController {
    @Resource(name = "slideImageService")
    private SlideImageService service;

    @RequestMapping("/queryAll")
    @ResponseBody
    public DataDTO<SlideImage> queryAll(Integer page, Integer rows) {
        Page p = new Page(page, rows);
        List<SlideImage> slideImages = service.queryAllSlideImage(p);
        DataDTO<SlideImage> slideImageDataDTO = new DataDTO<SlideImage>();
        slideImageDataDTO.setTotal(p.getTotalRows());
        slideImageDataDTO.setRows(slideImages);
        return slideImageDataDTO;
    }

    @RequestMapping("/queryOne")
    @ResponseBody
    public SlideImage queryOne(String id) {
        SlideImage image = new SlideImage();
        image.setId(id);
        return service.queryOneSlideImage(image);
    }

    @RequestMapping("/modify")
    @ResponseBody
    public void modify(SlideImage image) {
        service.modifySlideImage(image);
    }

    @RequestMapping("/add")
    @ResponseBody
    public void add(SlideImage image, MultipartFile uploadFile, HttpSession session) throws IOException {
        image.setSrc(uploadFile.getOriginalFilename());
        String contextPath = session.getServletContext().getRealPath("/img/indexImages");
        String path = contextPath + "\\" + uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File(path));
        service.addSlideImage(image);
    }

}
