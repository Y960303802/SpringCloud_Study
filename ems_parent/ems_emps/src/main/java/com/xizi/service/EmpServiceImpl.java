package com.xizi.service;


import com.xizi.dao.EmpDao;
import com.xizi.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public void update(Emp emp) {
        empDao.update(emp);
    }

    @Override
    public void save(Emp emp) {
        empDao.save(emp);
    }

    @Override
    public void delete(Integer id) {
        empDao.delete(id);
    }

    @Override
    public List<Emp> findAll() {
        return empDao.findAll();
    }
}
