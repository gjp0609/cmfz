package com.baizhi.service.impl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Page;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
}
