package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsFileUploadSupport;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import com.test.entity.UserInfo;

@Controller
@RequestMapping("/MultiController")
public class MultiController {

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse respose) {
		return new ModelAndView("multi", "method", "add");
	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request, HttpServletResponse respose) {
		request.setAttribute("method", "update");
		return "multi";
	}

	@RequestMapping("/showImg")
	public ModelAndView showImg(HttpServletRequest request,
			HttpServletResponse respose) {
		return new ModelAndView("img");
	}

	@RequestMapping("/del")
	public String del() {
		return "index";
	}

	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest req, HttpServletResponse resp) {
		return "addUser";
	}

	@RequestMapping("/showUser")
	public String showUser(UserInfo userInfo, HttpServletRequest req,
			HttpServletResponse resp) {
		req.setAttribute("userName", userInfo.getUserName());
		req.setAttribute("age", userInfo.getAge());
		return "showUser";
	}

	@RequestMapping("/testMap")
	public String testMap(ModelMap map, HttpServletRequest req) {
		map.put("key1", "value1");
		req.getSession().setAttribute("key2", "value2");
		return "testMap";
	}

	@RequestMapping("/showMapAndSession")
	public String showMapAndSession() {
		return "testMap";
	}

	@RequestMapping("/testRedirect")
	public String testRedirect() {
		return "redirect:http://www.baidu.com";
	}

	@RequestMapping("/testForward")
	public String testForward() {
		return "forward:testRedirect.do";
	}

	@RequestMapping("/testMV")
	public ModelAndView testMV() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("testMV");

		UserInfo info = new UserInfo("alan", "1");
		mv.addObject("userInfo", info);

		return mv;
	}

	@RequestMapping("/testUpload")
	public String testUpload() {
		return "upload";
	}

	@RequestMapping("/upload")
	public String upload(@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest req) {
		String filename = file.getOriginalFilename();
		req.setAttribute("filename", filename);
		if (file.isEmpty()) {
			return "upload_fail";
		} else {
			String savepath = req.getSession().getServletContext()
					.getRealPath("/upload");
			File saveFile = new File(savepath + "\\" + filename);
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
				return "upload_fail";
			} catch (IOException e) {
				e.printStackTrace();
				return "upload_fail";
			}
		}

		return "upload_success";
	}

	@RequestMapping("/createJSON")
	public String createJSON(HttpServletRequest req) {
		return "testAjax";
	}

	@RequestMapping("/showJSON")
	public @ResponseBody List<UserInfo> showJSON(HttpServletRequest req) {
		String name = req.getParameter("uname");
		System.out.println(name);
		List<UserInfo> infos = new ArrayList<UserInfo>();
		infos.add(new UserInfo("alan", "1"));
		infos.add(new UserInfo("emily", "2"));
		return infos;
	}
}
