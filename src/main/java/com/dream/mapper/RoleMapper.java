package com.dream.mapper;

import com.dream.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleMapper {
    Role selectRoleById(Integer id);
    void deleteBatch(int[] ids);
    int insertRole(Role role);

    List<Role> getRoles();
}
