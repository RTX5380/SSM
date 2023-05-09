package com.ssm.service.impl;

import com.ssm.dao.UserDao;
import com.ssm.domain.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User login(User user) {
        User user1 = userDao.selectUserByUsername(user.getUsername());
        return user1;
    }

}
