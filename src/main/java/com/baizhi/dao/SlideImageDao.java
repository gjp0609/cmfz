package com.baizhi.dao;


import com.baizhi.entity.Page;
import com.baizhi.entity.SlideImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by gjp06 on 17.6.13.
 */
public interface SlideImageDao {
    public List<SlideImage> selectSlideImage(@Param("slideImage") SlideImage slideImage, @Param("page") Page page);

    public int selectTotalRows();

    public int insertSlideImage(SlideImage slideImage);

    public int updateSlideImage(SlideImage slideImage);

    public int deleteSlideImage(SlideImage slideImage);

}
