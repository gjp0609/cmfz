package com.baizhi.service;

import com.baizhi.entity.Page;
import com.baizhi.entity.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * user
 * Created by gjp06 on 17.6.13.
 */
public interface UserService {
    public User queryOneUser(User user);

    public List<User> queryAllUser(Page page);

    public void modifyUser(User user);

    public List<Integer> getLoginChart();

    public Map<String, List<Map<String, Object>>> getMapChart();

    public HSSFWorkbook getAllDataExcel();

    public HSSFWorkbook getCustomExcel(String[] titles, String[] tits) throws Exception;

    public void importData(HSSFWorkbook workbook) throws FileNotFoundException, NoSuchMethodException, Exception;

}
