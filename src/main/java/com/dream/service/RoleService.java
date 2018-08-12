package com.dream.service;

import com.dream.pojo.Role;

/**
 *
 */
public interface RoleService {
    Role getRoleById(Integer id);
    void deleteBatch(int[] ids);
    int insertRole(Role role);
}
