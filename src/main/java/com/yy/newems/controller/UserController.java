package com.yy.newems.controller;


import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.yy.newems.entity.User;
import com.yy.newems.exception.AppException;
import com.yy.newems.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService iUserService;
	@RequestMapping("")
	public String index(){
		return "login";
	}
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "login";
	}
	
	@PostMapping("/login")
	public String login(String name, String pwd, HttpSession se, Map<String,Object> map, HttpServletRequest req){
		try {
			User user = iUserService.login(name,pwd);
			se.setAttribute("name",user.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
			if(e instanceof AppException){
				req.setAttribute("msg", e.getMessage());
				return "login";
			}
		}
		return "redirect:/emp/findAll";
	}
	@RequestMapping("/reg")
	public String regist(){
		return "regist";
	}
	@PostMapping("/toreg")
	public String toregist(String username,String name,String pwd,String sex,HttpServletRequest req){
		//System.out.println(username);
		boolean b = iUserService.addUser(username,name,pwd,sex);
		if(!b) {
			req.setAttribute("msg","注册成功，现在可以登录了");
			return "login";
		}
		System.out.println("注册失败");
		System.out.println(username+"_"+name+"_"+pwd+"_"+sex);
		req.setAttribute("msg","注册失败，内部错误");
		return "regist";

	}
}

