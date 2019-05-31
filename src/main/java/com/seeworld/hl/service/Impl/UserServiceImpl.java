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
    public User judgeLogin(String username, String pwd) {
        User  user=new User();
        user=userMapper.selectUserLogin(username,pwd);
        if(user!=null)
            return user;
        return null;
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

    @Override
    public int changePwd(int uid, String oldPwd, String newPwd) {
        System.out.println("now service");
        System.out.println(oldPwd);
        System.out.println(newPwd);
        System.out.println(uid);
        int result=0;
        User u=userMapper.selectUserByUId(uid);
        System.out.println("user="+u.getUUsername());
        System.out.println("userPWD="+u.getUPassword());
        if(u.getUPassword().equals(oldPwd))
        {
            result=userMapper.updatePwd(newPwd,uid);
        }
        System.out.println(result);
        return result;
    }

    @Override
    public int changeMine(int uid, String username, String personal) {
        System.out.println(personal);
        System.out.println(username);
        int result;
        result=userMapper.updateMine(personal, username, uid);
        return result;
    }
}
