package com.xizi.service;

import com.xizi.entity.User;

public interface UserService {
    void save(User user);


    User login(User user);
}
