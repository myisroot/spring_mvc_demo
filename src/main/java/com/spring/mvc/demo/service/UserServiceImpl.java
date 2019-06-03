package com.spring.mvc.demo.service;

import com.spring.mvc.demo.dao.UserDao;
import com.spring.mvc.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User get(Integer id) {
        return userDao.get(id);
    }

}
