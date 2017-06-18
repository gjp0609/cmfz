package com.baizhi.service.impl;

import com.baizhi.dao.LamaDao;
import com.baizhi.entity.Lama;
import com.baizhi.entity.Page;
import com.baizhi.service.LamaService;
import com.baizhi.utils.MyUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gjp06 on 17.6.14.
 */
@Service("lamaService")
@Transactional
public class LamaServiceImpl implements LamaService {

    @Resource(name = "lamaDao")
    private LamaDao dao;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Lama> queryAllLama(Page page) {
        int i = dao.selectTotalRows();
        page.setTotalRows(i);
        return dao.selectLama(new Lama(), page);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Lama queryOneLama(Lama lama) {
        List<Lama> lamaList = dao.selectLama(lama, new Page());
        if (lamaList == null || lamaList.size() < 1) throw new RuntimeException("lama not exist");
        return lamaList.get(0);
    }

    public void addLama(Lama lama) {
        String uuid = MyUtils.getUUID();
        lama.setId(uuid);
        int i = dao.insertLama(lama);
        if (i == 0) throw new RuntimeException("add lama fail");
    }

    public void modifyLama(Lama lama) {
        int i = dao.updateLama(lama);
        if (i == 0) throw new RuntimeException("add lama fail");
    }
}
