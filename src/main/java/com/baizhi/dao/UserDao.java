package com.baizhi.dao;


import com.baizhi.entity.Page;
import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by gjp06 on 17.6.12.
 */
public interface UserDao {
    /**
     * select user by user's username
     *
     * @param user select user from database by user usUsere
     * @return user object
     */
    public List<User> selectUser(@Param("user") User user, @Param("page") Page page);

    /**
     * insert user  to database
     *
     * @param user object to insert
     * @return 1 means success<br/> 0 means fails
     */
    public int insertUser(User user);

    /**
     * update user's username, password or real name
     *
     * @param user new user object
     * @return 1 means success<br/> 0 means fails
     */
    public int updateUser(User user);

    /**
     * delete user from database
     *
     * @param user use user's id
     * @return 1 means success<br/> 0 means fails
     */
    public int deleteUser(User user);
    public int selectTotalRows();


}
