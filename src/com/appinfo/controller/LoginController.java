package com.appinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.appinfo.pojo.User;
import com.appinfo.service.UserService;
import com.appinfo.tools.Constants;

/**
 * 登录控制
 * 
 * @author Waitforyou
 * 
 */

@Controller
public class LoginController {

	@Resource
	UserService userService;// 用户业务层

	/**
	 * 后台登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "dobaklogin.html")
	public String login(@RequestParam String name, @RequestParam String pwd,
			HttpServletRequest request, HttpSession session) throws Exception {

		User user = userService.login(name, pwd);
		if (null != user) {// 登录成功
			// 放入session
			session.setAttribute(Constants.USER_SESSION, user);
			// 页面跳转（frame.jsp）
			return "redirect:/sys/mamagerindex.html";
		} else {
			// 页面跳转（login.jsp）带出提示信息--转发
			request.setAttribute("error", "用户名或密码不正确");
			return "login";
		}

	}

	/**
	 * 前台登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "dologin.html")
	public String baklogin(@RequestParam("admin") String admin,
			@RequestParam("pwds") String pwds, HttpServletRequest request,
			HttpSession session) throws Exception {

		User user = userService.loginuser(admin, pwds);
		if (null != user) {// 登录成功
			// 放入session
			session.setAttribute(Constants.USER_SESSION, user);
			// 页面跳转（frame.jsp）
			return "redirect:/sys/index.html";
		} else {
			// 页面跳转（login.jsp）带出提示信息--转发
			request.setAttribute("error", "用户名或密码不正确");
			return "login";
		}

	}

}
