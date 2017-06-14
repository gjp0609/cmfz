package com.baizhi.dao;

import com.baizhi.entity.Lama;
import com.baizhi.entity.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by gjp06 on 17.6.14.
 */
public interface LamaDao {
    /**
     * select lama from database
     *
     * @param lama use lama id
     * @param page use first-page and page-index
     * @return lamaList
     */
    public List<Lama> selectLama(@Param("lama") Lama lama, @Param("page") Page page);

    /**
     * update lama's information(name)
     *
     * @param lama change name by lama's id
     * @return 1 means success<br/> 0 means fails
     */
    public int updateLama(Lama lama);

    /**
     * update lama's inform ation
     *
     * @param lama lama to update
     * @return 1 means success<br/> 0 means fails
     */
    public int insertLama(Lama lama);

    /**
     * get total rows in database
     *
     * @return total rows
     */
    public int selectTotalRows();
}
