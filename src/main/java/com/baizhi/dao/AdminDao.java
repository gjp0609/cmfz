package com.baizhi.dao;

import com.baizhi.entity.Admin;

/**
 * Created by gjp06 on 17.6.12.
 */
public interface AdminDao {
    /**
     * select admin by admin's username
     *
     * @param admin select admin from database by admin username
     * @return admin object
     */
    public Admin selectAdmin(Admin admin);

    /**
     * insert admin  to database
     *
     * @param admin object to insert
     * @return 1 means success<br/> 0 means fails
     */
    public int insertAdmin(Admin admin);

    /**
     * update admin's username, password or real name
     *
     * @param admin new admin object
     * @return 1 means success<br/> 0 means fails
     */
    public int updateAdmin(Admin admin);

    /**
     * delete admin from database
     *
     * @param admin use admin's id
     * @return 1 means success<br/> 0 means fails
     */
    public int deleteAdmin(Admin admin);
}
