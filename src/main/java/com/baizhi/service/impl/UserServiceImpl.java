package com.baizhi.service.impl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Page;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gjp06 on 17.6.16.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao dao;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User queryOneUser(User user) {
        List<User> users = dao.selectUser(user, new Page(1, 500));
        if (users == null || users.size() == 0) throw new RuntimeException("user to get is not exist");
        return users.get(0);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<User> queryAllUser(Page page) {
        page.setTotalRows(dao.selectTotalRows());
        return dao.selectUser(new User(), page);
    }

    public void modifyUser(User user) {
        int i = dao.updateUser(user);
        if (i == 0) throw new RuntimeException("modify user error");
    }

    public List<Integer> getChart1() {
        List<User> userList = dao.selectUser(new User(), new Page(1, 100));
        String[] record = new String[userList.size()];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = 0; j < 52; j++) {
            int k = 0;
            // 获得本周的
            for (int i = 0; i < userList.size(); i++) {
                record[i] = userList.get(i).getLoginRecord();
                char c = record[i].charAt(j);
                k += c - '0';
            }
            list.add(k);
        }
        return list;
    }

    public HSSFWorkbook getAllDataExcel() {
        // 创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // sheet 标题
        HSSFSheet sheet = workbook.createSheet("用户数据");
        // 表标题
        HSSFRow row1 = sheet.createRow(0);
        HSSFCell row1Cell = row1.createCell(0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String format = sdf.format(new Date());
        row1Cell.setCellValue("所有用户数据（" + format + "）");
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        HSSFFont font = workbook.createFont();
        font.setFontHeight((short) 300);
        cellStyle.setFont(font);
        row1Cell.setCellStyle(cellStyle);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 20));
        // 数据标题
        HSSFRow row2 = sheet.createRow(1);
        String[] titles = new String[]{"编号", "姓名", "法名", "电话号码", "头像路径", "密码", "密码盐",
                "性别", "状态", "国家", "地区", "签名", "邮箱", "注册时间", "最近登陆", "登陆记录", "上师id"};
        for (int i = 0; i < 17; i++) {
            HSSFCell cell = row2.createCell(i);
            cell.setCellValue(titles[i]);
        }
        // 插入数据行
        int k = dao.selectTotalRows();
        List<User> userList = dao.selectUser(new User(), new Page(1, k));
        for (int i = 2; i < k + 2; i++) {
            HSSFRow row = sheet.createRow(i);
            row.createCell(0).setCellValue(userList.get(i - 2).getId());
            row.createCell(1).setCellValue(userList.get(i - 2).getName());
            row.createCell(2).setCellValue(userList.get(i - 2).getFaName());
            row.createCell(3).setCellValue(userList.get(i - 2).getPhone());
            row.createCell(4).setCellValue(userList.get(i - 2).getSrc());
            row.createCell(5).setCellValue(userList.get(i - 2).getPassword());
            row.createCell(6).setCellValue(userList.get(i - 2).getSalt());
            row.createCell(7).setCellValue(userList.get(i - 2).getSex());
            row.createCell(8).setCellValue(userList.get(i - 2).getStatus());
            row.createCell(9).setCellValue(userList.get(i - 2).getProvince());
            row.createCell(10).setCellValue(userList.get(i - 2).getArea());
            row.createCell(11).setCellValue(userList.get(i - 2).getSign());
            row.createCell(12).setCellValue(userList.get(i - 2).getEmail());
            HSSFCellStyle style = workbook.createCellStyle();
            style.setDataFormat(workbook.createDataFormat().getFormat("yyyy-MM-dd"));
            row.createCell(13).setCellValue(userList.get(i - 2).getRegisterTime());
            row.createCell(14).setCellValue(userList.get(i - 2).getLastLoginTime());
            row.createCell(15).setCellValue(userList.get(i - 2).getLoginRecord());
            row.createCell(16).setCellValue(userList.get(i - 2).getLama().getId());
        }
        return workbook;
    }

    public HSSFWorkbook getCustomExcel(String[] titles1, String[] titles2) throws Exception {
        List<User> userList = dao.selectUser(new User(), new Page(1, dao.selectTotalRows()));
        Workbook workbook = new HSSFWorkbook();
        for (User user : userList) {
            titles1 = new String[]{"编号", "姓名", "法名", "注册时间"};
            // 标题列数组
            titles2 = new String[]{"id", "name", "faName", "registerTime"};
            // 遍历 User 方法
            Method[] methods = User.class.getMethods();
            for (String s : titles2) {
                // 将标题名转换为对应的get方法名  id --> getId   name --> getName
                String methodName = "get" + (char) (s.charAt(0) - 'a' + 'A') + s.substring(1);
                for (Method method : methods) {
                    // 如果方法名对应则执行方法
                    if (method.getName().equals(methodName)) {
                        // 得到结果
                        System.out.println(method.invoke(user));
                        // 拿到方法返回类型
                        Class<?> type = method.getReturnType();
                        // 如果为日期类型，则自定义格式
                        if (type.newInstance() instanceof Date) {
                            //System.out.println(true);
                        }
                    }
                }
            }
        }
        return null;

    }


}
