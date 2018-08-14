package com.dream.service;

import com.dream.pojo.Role;

import java.util.List;

/**
 *
 */
public interface RoleService {
    Role getRoleById(Integer id);
    void deleteBatch(int[] ids);
    int insertRole(Role role);

    List<Role> getRoles();
}
