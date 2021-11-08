package com.yy.newems.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.newems.entity.Emp;
import com.yy.newems.mapper.EmpMapper;
import com.yy.newems.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> findAllEmp() {
        List<Emp> empList = empMapper.selectList(null);
        return empList;
    }

    @Override
    public void deleteById(Integer id) {
        empMapper.deleteById(id);
        System.out.println("id:" + id);
    }

    @Override
    public boolean updateEmp(Integer id, String name, Double salary, Integer age) {
        Emp emp = new Emp();
        emp.setEid(id);
        emp.setEname(name);
        emp.setSalary(salary);
        emp.setAge(age);
        int res = empMapper.updateById(emp);
        if (res > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addEmp(String name, Double salary, Integer age) {
        Emp emp = new Emp();
        emp.setEid(null);
        emp.setEname(name);
        emp.setSalary(salary);
        emp.setAge(age);

        int res = empMapper.insert(emp);
        if (res > 0) {
            return true;
        }
        return false;
    }
}
