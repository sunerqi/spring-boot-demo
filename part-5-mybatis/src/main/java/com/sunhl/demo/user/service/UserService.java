package com.sunhl.demo.user.service;

import com.sunhl.demo.user.domain.User;
import org.springframework.stereotype.Service;

/**
 * @Author: sunhailong
 * @Date: 2022/7/28 16:44
 * @Desc:
 */
@Service
public interface UserService {
    User getUserById(int id);
}
