package com.xizi.service;

import com.xizi.dao.UserDao;
import com.xizi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {

        User byUserName = userDao.findByUserName(user.getUsername());
        if(byUserName==null){
            throw new RuntimeException("用户名输入错误！！！");
        }
        if(!user.getPassword().equals(byUserName.getPassword())){
            throw  new RuntimeException("密码输入错误！！！");
        }

        return byUserName;
    }

    @Override
    public void save(User user) {
        User byUserName = userDao.findByUserName(user.getUsername());
        if(byUserName!=null){
            throw  new RuntimeException("已存在用户~~~");
        }
        user.setStatus("已激活");
        user.setRegisterTime(new Date());
        userDao.save(user);

    }


}
