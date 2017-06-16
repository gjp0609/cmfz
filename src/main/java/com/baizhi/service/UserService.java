package com.baizhi.service;

import com.baizhi.entity.Page;
import com.baizhi.entity.User;

import java.util.List;

/**
 * user
 * Created by gjp06 on 17.6.13.
 */
public interface UserService {
    public User queryOneUser(User user);

    public List<User> queryAllUser(Page page);

    public void modifyUser(User user);

}
