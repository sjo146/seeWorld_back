package com.seeworld.hl.service;

import com.seeworld.hl.domain.User;

public interface UserService {
    User judgeLogin(String username,String pwd);
    int addUser(User user);
}
