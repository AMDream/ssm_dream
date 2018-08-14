package com.dream.service;

import com.dream.pojo.User;

/**
 *
 */
public interface UserService {
    boolean findRole(String username,String password);
    User findUser(Integer id);
}
