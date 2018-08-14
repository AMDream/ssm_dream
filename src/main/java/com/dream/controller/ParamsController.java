package com.dream.controller;

import com.dream.pojo.Role;
import com.dream.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("/params")
public class ParamsController {
    @Autowired
    RoleService rs = null;
    /**
     * 名称相同，参数自动绑定
     */
    @RequestMapping("/commonParams")
    public String commonParams(String roleName,String note){
        System.out.println("roleName =>"+roleName);
        System.out.println("note =>"+note);
        return "hello";
    }

    /**
     *POJO属性和form表单中的name一致，自动绑定到pojo中
     */
    @RequestMapping("/commonParamsPojo")
    public String commonParamsPojo(Role role){
        System.out.println("roleName = >" + role.getRoleName());
        System.out.println("note = >" + role.getNote());
        return "index";
    }

    /**
     * RequestParam注解获取参数
     */
    @RequestMapping("/requestParam")

    public String requestParam(@RequestParam("role_name")String roleName, String note){
        System.out.println("roleName = >"+roleName);
        System.out.println("note =>"+note);
        return "hello";
    }

    /**
     * URL的形式传递参数
     */
    @RequestMapping("/getRole/{id}")
    public String pathVariable(@PathVariable("id") Integer id){
        Role role = rs.getRoleById(id);
        System.out.println(role);
        return "index";
    }

    /**
     * 传递JSON参数
     */
    @RequestMapping("/findRoles")
    @ResponseBody
    public List<String> findRoles(@RequestBody Role role){
        System.out.println("耿耿："+role);
        List<String> result = new ArrayList<>();
        result.add("SUCCESS");
        return result;
    }
    /**
    * 接收JSON列表数据
     */
    @RequestMapping("/deleteRoles")
    @ResponseBody
    public ModelAndView deleteRoles(@RequestBody List<Integer> ids){
        ModelAndView mv = new ModelAndView();
        mv.addObject("total",ids.size());
        mv.addObject("ids",ids);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }
    /**
     * 序列化提交表单
     * Error:$('form').serialize()不管用
     */
    @RequestMapping("/commonParamPojo2")
    public String commonParamPojo2(String roleName,String note){
        System.out.println("roleName = >"+roleName);
        System.out.println("note = >"+note);
        return "hello";
    }
}
