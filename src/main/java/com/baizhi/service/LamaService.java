package com.baizhi.service;

import com.baizhi.entity.Lama;
import com.baizhi.entity.Page;

import java.util.List;

/**
 * service
 * Created by gjp06 on 17.6.14.
 */
public interface LamaService {
    public List<Lama> queryAllLama(Page page);

    public Lama queryOneLama(Lama lama);

    public void addLama(Lama lama);

    public void modifyLama(Lama lama);


}
