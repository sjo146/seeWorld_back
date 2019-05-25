package com.seeworld.hl.service.Impl;

import com.seeworld.hl.dao.UserMapper;
import com.seeworld.hl.domain.User;
import com.seeworld.hl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Override
    public boolean judgeLogin(String username, String pwd) {
        User  user=new User();
        user=userMapper.selectUserLogin(username,pwd);
        if(user!=null)
            return true;
        return false;
    }

    @Override
    public int addUser(User user) {
        User u=new User();
        u=userMapper.selectUserByUsername(user.getUUsername());
        if(u!=null)
            return 1;
        int result=userMapper.insertUser(user);
        if(result==1)
            return 2;
        return 3;
    }
}
