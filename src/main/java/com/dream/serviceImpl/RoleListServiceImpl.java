package com.dream.serviceImpl;

import com.dream.pojo.Role;
import com.dream.service.RoleListService;
import com.dream.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RoleListServiceImpl implements RoleListService{
    @Autowired
    RoleService rs = null;

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public int insertRoleList(List<Role> roles) {
        int cnt = 0;
        for(Role role : roles){
            System.out.println(role);
            cnt += rs.insertRole(role);
        }
        return cnt;
    }
}
