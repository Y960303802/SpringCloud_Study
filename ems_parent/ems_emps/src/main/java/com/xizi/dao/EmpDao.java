package com.xizi.dao;

import com.xizi.entity.Emp;

import java.util.List;

public interface EmpDao {

    List<Emp> findAll();

    void save(Emp emp);

    void delete(Integer id);

    void update(Emp emp);
}
