package com.shiyan.service.impl;

import com.shiyan.dao.UserMapper;
import com.shiyan.domain.User;
import com.shiyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
