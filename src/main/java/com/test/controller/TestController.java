package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/TestController")
public class TestController implements
		org.springframework.web.servlet.mvc.Controller {

	@RequestMapping("/sayHello")
	ModelAndView sayHello() {
		return new ModelAndView("/test");
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("TestController.handleRequest");
		return new ModelAndView("/index");
	}

}
