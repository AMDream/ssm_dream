package com.dream.others;

import com.dream.config.ApplicationConfig;
import com.dream.pojo.Role;
import com.dream.service.RoleListService;
import com.dream.service.RoleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        RoleListService rs = ac.getBean(RoleListService.class);
        /*Role role = rs.getRoleById(1);
        System.out.println(role);*/
        List<Role> roles = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Role role = new Role();
            role.setRoleName("role_name"+(i+1));
            role.setNote("note_"+(i+1));
            roles.add(role);
        }
        int result = rs.insertRoleList(roles);
        System.out.println(result);
    }
}
