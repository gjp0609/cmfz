package com.baizhi.service;

import com.baizhi.entity.Page;
import com.baizhi.entity.SlideImage;

import java.util.List;

/**
 * Created by gjp06 on 17.6.13.
 */
public interface SlideImageService {
    public SlideImage queryOneSlideImage(SlideImage slideImage);

    public List<SlideImage> queryAllSlideImage(Page page);

    public void addSlideImage(SlideImage slideImage);

    public void modifySlideImage(SlideImage slideImage);

    public void removeSlideImage(SlideImage slideImage);
}
