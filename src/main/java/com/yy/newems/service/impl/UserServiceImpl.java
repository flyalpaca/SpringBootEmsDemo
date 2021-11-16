package com.yy.newems.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.newems.entity.User;
import com.yy.newems.exception.AppException;
import com.yy.newems.mapper.UserMapper;
import com.yy.newems.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String pwd) {
        QueryWrapper<User> qw = new QueryWrapper<User>();
        User user = userMapper.selectOne(qw.eq("username",username));
        //System.out.println(user);
        if(user == null){
            throw new AppException("用户不存在");
        }
        if(!user.getPassword().equals(pwd)){
            throw new AppException("密码错误");
        }
        return user;
    }

    @Override
    public boolean addUser(String username, String name, String pwd, String sex) {
        User user = new User();
        user.setUsername(username);
        user.setRealname(name);
        user.setPassword(pwd);
        user.setGender(sex);

        int res = userMapper.insert(user);
        if(res>1){
            return true;
        }
        return false;
    }

}
