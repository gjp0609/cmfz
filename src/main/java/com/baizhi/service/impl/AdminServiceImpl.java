package com.baizhi.service.impl;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.utils.MyUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by gjp06 on 17.6.12.
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

    @Resource(name = "adminDao")
    private AdminDao dao;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Admin queryAdmin(Admin admin) {
        if (admin == null) throw new RuntimeException("admin to query is empty");
        if (admin.getUsername() == null) throw new RuntimeException("username is null");
        Admin dbAdmin = dao.selectAdmin(admin);
        if (dbAdmin == null) throw new RuntimeException("user not exists");
        String md5 = MyUtils.getMD5(admin.getPassword() + dbAdmin.getSalt());
        if (!md5.equals(dbAdmin.getPassword())) throw new RuntimeException("password is incorrect");
        return dbAdmin;
    }

    public void addAdmin(Admin admin) {
        if (admin == null) throw new RuntimeException("admin to insert is empty");
        int i = dao.insertAdmin(admin);
        if (i == 0) throw new RuntimeException("add admin fail");
    }

    public void modifyAdmin(Admin admin) {
        if (admin == null) throw new RuntimeException("admin to update is empty");
        if (admin.getUsername() == null) throw new RuntimeException("admin to update name is empty");
        if (admin.getPassword() == null) throw new RuntimeException("admin to update password is empty");
        Admin dbAdmin = dao.selectAdmin(admin);
        if (dbAdmin == null) throw new RuntimeException("user not exists");
        String salt = MyUtils.getRandomCode(10);
        String newPwd = MyUtils.getMD5(admin.getPassword() + salt);
        dbAdmin.setSalt(salt);
        dbAdmin.setPassword(newPwd);
        int i = dao.updateAdmin(dbAdmin);
        if (i == 0) throw new RuntimeException("modify admin fail");
    }

    public void removeAdmin(Admin admin) {
        if (admin == null) throw new RuntimeException("admin to delete is empty");
        int i = dao.deleteAdmin(admin);
        if (i == 0) throw new RuntimeException("remove admin fail");
    }
}
