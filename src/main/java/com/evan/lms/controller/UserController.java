package com.evan.lms.controller;


import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.evan.lms.entity.User;
import com.evan.lms.service.UserService;
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("login")
	public String login(User user){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword().toCharArray());
		
		try {
			subject.login(token);
			Session session=subject.getSession();
			System.out.println("sessionId:"+session.getId());
			System.out.println("sessionHost:"+session.getHost());
			System.out.println("sessionTimeout:"+session.getTimeout());
			session.setAttribute("info", "session的数据");
			
			return "redirect:/success.jsp";
		} catch (Exception e) {
			return "index";
		}
		
		
	}
	
	@RequestMapping("/admin")
	public String adminGet(){
		System.out.println("sjodjosijo-----1");
		System.out.println("sjodjosijo-----2");
		System.out.println("sjodjosijo-----3");
		return "admin";
		
	}
	
	
	@RequestMapping("/news")
	public String news(){
		System.out.println("sjodjosijo-----1");
		System.out.println("sjodjosijo-----2");
		System.out.println("sjodjosijo-----3");
		return "news";
	}

	
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser(Model model){
		User user = userService.getUserByName("aa");
		return user;
	}
	@RequestMapping("/getUsers")
	@ResponseBody
	public List<User> getUsers(Model model){
		List<User> users = userService.findUserList();
		return users;
	}

}
