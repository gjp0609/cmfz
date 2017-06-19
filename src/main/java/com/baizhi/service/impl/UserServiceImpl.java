package com.baizhi.service.impl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Lama;
import com.baizhi.entity.Page;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.utils.MyUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public List<Integer> getLoginChart() {
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

    public Map<String, List<Map<String, Object>>> getMapChart() {
        List<User> userList = dao.selectUser(new User(), new Page(1, 100));
        // 总 map 包含 M/F 两种数据
        Map<String, List<Map<String, Object>>> map = new HashMap<String, List<Map<String, Object>>>();
        // 一种数据
        ArrayList<Map<String, Object>> maleList = new ArrayList<Map<String, Object>>();
        // 另一种数据
        ArrayList<Map<String, Object>> femaleList = new ArrayList<Map<String, Object>>();

        for (User user : userList) {
            Map<String, Object> maleMap = new HashMap<String, Object>();
            Map<String, Object> femaleMap = new HashMap<String, Object>();
            if (user.getSex().equals("M")) {
                maleMap.put("value", 1);
                // 已有数据
                for (Map<String, Object> map1 : maleList) {
                    if (map1.containsValue(user.getProvince())) {
                        maleList.remove(map1);
                        maleMap = map1;
                        maleMap.put("value", (Integer) map1.get("value") + 1);
                        break;
                    }
                }
                maleMap.put("name", user.getProvince());
                maleList.add(maleMap);
            } else {
                femaleMap.put("value", 1);
                // 已有数据
                for (Map<String, Object> map1 : femaleList) {
                    if (map1.containsValue(user.getProvince())) {
                        femaleMap = map1;
                        femaleMap.put("value", (Integer) map1.get("value") + 1);
                        break;
                    }
                }
                femaleMap.put("name", user.getProvince());
                femaleList.add(femaleMap);
            }
        }
        map.put("male", maleList);
        map.put("female", femaleList);
        return map;
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
//        System.out.println(Arrays.toString(titles2));
        // 创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // sheet 标题
        HSSFSheet sheet = workbook.createSheet("用户数据");
        // 表标题
        HSSFRow row1 = sheet.createRow(0);
        HSSFCell row1Cell = row1.createCell(0);
        row1Cell.setCellValue("所有用户数据（" + MyUtils.fmtDate(new Date()) + "）");
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        HSSFFont font = workbook.createFont();
        font.setFontHeight((short) 300);
        cellStyle.setFont(font);
        row1Cell.setCellStyle(cellStyle);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, titles1.length - 1));
        // 数据标题
        HSSFRow row2 = sheet.createRow(1);
        for (int i = 0; i < titles1.length; i++) {
            HSSFCell cell = row2.createCell(i);
            cell.setCellValue(titles1[i]);
        }

        // 设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(workbook.createDataFormat().getFormat("yyyy-MM-dd"));

        List<User> userList = dao.selectUser(new User(), new Page(1, dao.selectTotalRows()));
        // 遍历用户
        for (int userIdx = 0; userIdx < userList.size(); userIdx++) {
            // 表格创建一行（每个用户对应一行）
            HSSFRow row = sheet.createRow(userIdx + 2);
            User user = userList.get(userIdx);
            // 遍历标题  一个user对象  一个标题集合
            for (int titleIdx = 0; titleIdx < titles2.length; titleIdx++) {
                sheet.autoSizeColumn(titleIdx);
                String field = titles2[titleIdx];
                // 将标题名转换为对应的get方法名  id --> getId   name --> getName
                String methodName = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
                // 得到 User 方法
                Method[] methods = User.class.getMethods();
                Method method = User.class.getMethod("methodName");
                // 得到结果
                Object result = method.invoke(user);
                // 拿到方法返回类型
                Class<?> type = method.getReturnType();
                // 如果为日期类型，则自定义格式
                if (type.newInstance() instanceof Date) {
//                    System.out.println(result);
                    HSSFCell cell = row.createCell(titleIdx);
                    // 插入表格
                    cell.setCellValue((Date) result);
                    cell.setCellStyle(style);
                } else {
                    // 插入表格
                    row.createCell(titleIdx).setCellValue((String) result);
                }
            }
        }
        return workbook;
    }

    public void importData(HSSFWorkbook workbook) throws Exception {
        List<User> userList = new ArrayList<User>();
        String[] titles = new String[]{"id", "name", "faName", "phone", "src", "password", "salt", "sex", "status",
                "province", "area", "sign", "email", "registerTime", "lastLoginTime", "loginRecord", "lama"};
        HSSFSheet sheet = workbook.getSheetAt(0);
        for (int j = 2; j <= sheet.getLastRowNum(); j++) {
            // 获取每一条数据
            HSSFRow row = sheet.getRow(j);
            User user = new User();
            for (int i = 0; i < titles.length; i++) {
                String methodName = "set" + titles[i].substring(0, 1).toUpperCase() + titles[i].substring(1);
                // 获取每一个单元格
                HSSFCell cell = row.getCell(i);
                HSSFCellStyle cellStyle = cell.getCellStyle();
                if (methodName.equals("setLama")) {
                    Method method = User.class.getMethod(methodName, Lama.class);
                    Lama lama = new Lama();
                    lama.setId(cell.getStringCellValue());
                    method.invoke(user, lama);
                } else if ("@".equals(cellStyle.getDataFormatString())) {
                    Method method = User.class.getMethod(methodName, String.class);
                    method.invoke(user, cell.getStringCellValue());
                } else if ("yyyy\\-mm\\-dd".equals(cellStyle.getDataFormatString())) {
                    Method method = User.class.getMethod(methodName, Date.class);
                    method.invoke(user, cell.getDateCellValue());
                } else System.err.println("unKnown method " + methodName);
            }
            userList.add(user);
        }
        // 批量插入
        dao.insertUsers(userList);
    }


}
