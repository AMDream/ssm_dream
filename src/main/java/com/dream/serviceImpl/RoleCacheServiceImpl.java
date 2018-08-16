package com.dream.serviceImpl;

import com.dream.mapper.RoleMapper;
import com.dream.pojo.Role;
import com.dream.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service("roleCache")
public class RoleCacheServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper = null;

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @Cacheable(value = "redisCacheManager",key = "'redis_role_'+#id")
    public Role getRoleById(Integer id) {
        System.out.println("Get:"+id);
        return roleMapper.selectRoleById(id);
    }

    @Override
    public void deleteBatch(int[] ids) {
        roleMapper.deleteBatch(ids);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @CachePut(value = "redisCacheManager",key = "'redis_role_'+#role.getId()")
    public Role insertRole(Role role) {
        roleMapper.insertRole(role);
        return role;
    }

    @Override
    public List<Role> getRoles() {
        return roleMapper.getRoles();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @CacheEvict(value = "redisCacheManager",key = "'redis_role_'+#id")
    public int deleteRole(Integer id) {
        return roleMapper.deleteRole(id);
    }
}
