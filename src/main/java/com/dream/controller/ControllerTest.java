package com.dream.controller;

import com.dream.pojo.Role;
import com.dream.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("/role")
public class ControllerTest {
    @Autowired
    private RoleService rs = null;

    @RequestMapping("/getRole")
    public ModelAndView getRole(@RequestParam(value = "id",required = false) Integer id){
        if (id == null)
            id = 1;
        Role role = rs.getRoleById(id);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("role",role);
        return mv;
    }
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/json")
    @ResponseBody
    public List<String> list() {
        List<String> result = new ArrayList<>();
        result.add("hello");
        result.add("Dream");
        result.add("Mary");
        result.add("David");
        return result;
    }
}
