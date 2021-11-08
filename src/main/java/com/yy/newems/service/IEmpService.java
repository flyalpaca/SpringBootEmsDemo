package com.yy.newems.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.newems.entity.Emp;

import java.util.List;

public interface IEmpService extends IService<Emp> {

    public List<Emp> findAllEmp();

    public void deleteById(Integer id);

    boolean updateEmp(Integer id, String name, Double salary, Integer age);

    boolean addEmp(String name, Double salary, Integer age);
}
