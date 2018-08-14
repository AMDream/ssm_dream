package com.dream.controller;

import com.dream.config.view.ExcelView;
import com.dream.pojo.Role;
import com.dream.service.ExcelExportService;
import com.dream.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("/excel")
public class ExcelExportController {
    @Autowired
    private RoleService rs = null;
    @Autowired
    private ExcelExportService es = null;

    @RequestMapping("/export")
    public ModelAndView export(){
        System.out.println("In EXPORT");
        ModelAndView mv = new ModelAndView();
        System.out.println(es == null);
        ExcelView ev = new ExcelView(es);
        ev.setFileName("所有角色.xls");
        List<Role> roles = rs.getRoles();
        mv.addObject("roleList",roles);
        mv.setView(ev);
        return mv;
    }
}
