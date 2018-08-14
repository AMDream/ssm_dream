package com.dream.serviceImpl;

import com.dream.mapper.UserMapper;
import com.dream.pojo.User;
import com.dream.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper um = null;

    @Override
    public boolean findRole(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User result = um.selectUserByNamePwd(user);
        if (result == null)
            return false;
        return true;
    }

    @Override
    public User findUser(Integer id) {
        return null;
    }
}
