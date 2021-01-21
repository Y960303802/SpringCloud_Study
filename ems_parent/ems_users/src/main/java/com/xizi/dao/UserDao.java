package com.xizi.dao;

import com.xizi.entity.User;

public interface UserDao {

   void save(User user);

    User findByUserName(String username);

}
