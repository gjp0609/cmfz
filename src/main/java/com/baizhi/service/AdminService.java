package com.baizhi.service;

import com.baizhi.entity.Admin;

/**
 * Created by gjp06 on 17.6.12.
 */
public interface AdminService {


    public Admin queryAdmin(Admin admin);

    public void addAdmin(Admin admin);

    public Admin queryOne(Admin admin);

    public void modifyAdmin(Admin admin, String oldPassword);

    public void removeAdmin(Admin admin);
}
