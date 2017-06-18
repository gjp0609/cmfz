package com.baizhi.service;

import com.baizhi.entity.Page;
import com.baizhi.entity.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

/**
 * user
 * Created by gjp06 on 17.6.13.
 */
public interface UserService {
    public User queryOneUser(User user);

    public List<User> queryAllUser(Page page);

    public void modifyUser(User user);

    public List<Integer> getChart1();

    public HSSFWorkbook getAllDataExcel();

    public HSSFWorkbook getCustomExcel(String[] titles, String[] tits) throws Exception;

}
