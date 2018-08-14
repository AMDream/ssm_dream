package com.dream.mapper;

import com.dream.pojo.User;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface UserMapper {
    User selectUserByNamePwd(User user);
    User selectUserById(Integer id);
}
