package com.test.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.test.inv.handler.DynaProxyInvHandler;
import com.test.model.User;
import com.test.service.IUserService;
import com.test.service.impl.UserServiceImpl;

@Controller
@RequestMapping("UserController")
public class UserController {
	@Autowired
	private IUserService userService;
	
	private DynaProxyInvHandler dynaProxyInvHandler;

	@RequestMapping("/reg")
	public String register() {
		dynaProxyInvHandler = new DynaProxyInvHandler();
		return "index";
	}

	@RequestMapping("/user")
	public ModelAndView addUser(User user) {
		ModelAndView mav = null;
		user.setId(UUID.randomUUID().toString());
		user.setRegtime(new Date());
		mav = new ModelAndView();
		try {
//			userService.addUser(user);
			// request.setAttribute("user", user);
			IUserService serviceProxy = (IUserService)dynaProxyInvHandler.bind(userService);
			serviceProxy.addUser(user);
			
			mav.setViewName("success");
			mav.addObject("user", user);
			mav.addObject("msg", "注册成功了，可以去登陆了");
			return mav;
		} catch (Exception e) {
			mav.setViewName("fail");
			mav.addObject("user", null);
			mav.addObject("msg", "注册失败");
			return mav;
		}
	}
	
	@RequestMapping("/getAllUsers")
	public ModelAndView getAllUsers()
	{
		ModelAndView mv = new ModelAndView("allUsers");
		List<User> users = userService.getAllUsers();
		mv.addObject("users", users);
		return mv;
	}
}
