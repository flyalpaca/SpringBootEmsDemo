package com.yy.newems.controller;


import com.yy.newems.entity.Emp;
import com.yy.newems.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private IEmpService iEmpService;

    @RequestMapping("/findAll")
    public String findall(Model model) {
        List<Emp> empList = iEmpService.findAllEmp();
        model.addAttribute("emplist", empList);
        return "emplist";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        iEmpService.deleteById(id);
        return "redirect:/emp/findAll";
    }

    @GetMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("e", iEmpService.getById(id));
        return "updateEmp";
    }

    @PostMapping("/update")
    public String update(Integer id, String name, Double salary, Integer age, HttpServletRequest req) {
        boolean result = iEmpService.updateEmp(id, name, salary, age);
        if (result) {
            return "redirect:/emp/findAll";
        }
        req.setAttribute("msg", "修改失败");
        return "redirect:/emp/toupdate/" + id;
    }

    @GetMapping("/add")
    public String add() {
        return "addEmp";
    }

    @PostMapping("/toadd")
    public String toadd(String name, Double salary, Integer age, HttpServletRequest req) {
        // System.out.println(name);
        boolean result = iEmpService.addEmp(name, salary, age);
        return "redirect:/emp/findAll/";
    }

    @PostMapping("/serch")
    public String serch(String key, Model model) {
        //System.out.println(key);
        List<Emp> empList = iEmpService.findLikeName(key);
        model.addAttribute("emplist", empList);
        return "emplist";
    }
}

