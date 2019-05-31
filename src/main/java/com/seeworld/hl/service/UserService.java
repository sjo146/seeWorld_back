package com.seeworld.hl.service;

import com.seeworld.hl.domain.User;

public interface UserService {
    User judgeLogin(String username,String pwd);
    int addUser(User user);
    int changePwd(int uid,String oldPwd,String newPwd);
    int changeMine(int uid,String username,String personal);
}
