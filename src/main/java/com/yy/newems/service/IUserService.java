package com.yy.newems.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.newems.entity.User;

public interface IUserService extends IService<User> {
	
	public User login(String username,String pwd);

	boolean addUser(String username, String name, String pwd, String sex);
}
