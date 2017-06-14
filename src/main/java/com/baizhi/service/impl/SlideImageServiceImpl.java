package com.baizhi.service.impl;

import com.baizhi.dao.SlideImageDao;
import com.baizhi.entity.Page;
import com.baizhi.entity.SlideImage;
import com.baizhi.service.SlideImageService;
import com.baizhi.utils.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * slideImageService
 * Created by gjp06 on 17.6.13.
 */
@Service("slideImageService")
@Transactional
public class SlideImageServiceImpl implements SlideImageService {

    @Resource(name = "slideImageDao")
    private SlideImageDao dao;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public SlideImage queryOneSlideImage(SlideImage slideImage) {
        List<SlideImage> slideImages = dao.selectSlideImage(slideImage, new Page());
        if (slideImages == null || slideImages.size() == 0)
            throw new RuntimeException("no slide image data");
        return slideImages.get(0);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<SlideImage> queryAllSlideImage(Page page) {
        int i = dao.selectTotalRows();
        page.setTotalRows(i);
        List<SlideImage> slideImages = dao.selectSlideImage(new SlideImage(), page);
        if (slideImages == null || slideImages.size() == 0)
            throw new RuntimeException("no slide image data");
        return slideImages;
    }

    public void addSlideImage(SlideImage slideImage) {
        slideImage.setId(SecurityUtils.getUUID());
        int i = dao.insertSlideImage(slideImage);
        if (i == 0) throw new RuntimeException("add slide image fail");
    }

    public void modifySlideImage(SlideImage slideImage) {
        int i = dao.updateSlideImage(slideImage);
        if (i == 0) throw new RuntimeException("modify slide image fail");
    }

    public void removeSlideImage(SlideImage slideImage) {
        int i = dao.deleteSlideImage(slideImage);
        if (i == 0) throw new RuntimeException("remove slide image fail");
    }
}
