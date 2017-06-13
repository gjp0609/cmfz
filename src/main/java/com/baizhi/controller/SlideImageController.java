package com.baizhi.controller;

import com.baizhi.entity.Page;
import com.baizhi.entity.SlideImage;
import com.baizhi.entity.SlideImageDTO;
import com.baizhi.service.SlideImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
    public SlideImageDTO queryAll(Integer page, Integer rows) {
        Page p = new Page(page, rows);
        List<SlideImage> slideImages = service.queryAllSlideImage(p);
        SlideImageDTO slideImageDTO = new SlideImageDTO();
        slideImageDTO.setTotal(p.getTotalRows());
        slideImageDTO.setRows(slideImages);
        return slideImageDTO;
    }
}
