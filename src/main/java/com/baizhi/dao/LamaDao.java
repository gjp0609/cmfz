package com.baizhi.dao;

import com.baizhi.entity.Lama;
import com.baizhi.entity.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by gjp06 on 17.6.14.
 */
public interface LamaDao {
    public List<Lama> selectLama(@Param("lama") Lama lama, @Param("page") Page page);

    public int updateLama(Lama lama);

    public int insertLama(Lama lama);

    public int selectTotalRows();
}
