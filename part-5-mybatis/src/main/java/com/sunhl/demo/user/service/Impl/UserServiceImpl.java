package com.sunhl.demo.user.service.Impl;

import com.sunhl.demo.user.domain.User;
import com.sunhl.demo.user.mapper.UserMapper;
import com.sunhl.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: sunhailong
 * @Date: 2022/7/28 16:44
 * @Desc:
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
