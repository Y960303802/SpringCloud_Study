package com.xizi.service;

import com.xizi.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> findAll();

    void save(Emp emp);

    void delete(Integer id);

    void update(Emp emp);
}
