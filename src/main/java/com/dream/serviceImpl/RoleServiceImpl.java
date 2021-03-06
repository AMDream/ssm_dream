package com.dream.serviceImpl;

import com.dream.mapper.RoleMapper;
import com.dream.pojo.Role;
import com.dream.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleMapper roleMapper = null;


    public Role getRoleById(Integer id) {
        return roleMapper.selectRoleById(id);
    }

    public void deleteBatch(int[] ids){
        roleMapper.deleteBatch(ids);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.DEFAULT)
    public Role insertRole(Role role) {
        roleMapper.insertRole(role);
        return role;
    }

    @Override
    public List<Role> getRoles() {
        return roleMapper.getRoles();
    }

    @Override
    public int deleteRole(Integer id) {
        return roleMapper.deleteRole(id);
    }
}
