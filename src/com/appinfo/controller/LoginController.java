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
 * ��¼����
 * 
 * @author Waitforyou
 * 
 */

@Controller
public class LoginController {

	@Resource
	UserService userService;// �û�ҵ���

	/**
	 * ��̨��¼
	 * 
	 * @return
	 */
	@RequestMapping(value = "dobaklogin.html")
	public String login(@RequestParam String name, @RequestParam String pwd,
			HttpServletRequest request, HttpSession session) throws Exception {

		User user = userService.login(name, pwd);
		if (null != user) {// ��¼�ɹ�
			// ����session
			session.setAttribute(Constants.USER_SESSION, user);
			// ҳ����ת��frame.jsp��
			return "redirect:/sys/mamagerindex.html";
		} else {
			// ҳ����ת��login.jsp��������ʾ��Ϣ--ת��
			request.setAttribute("error", "�û��������벻��ȷ");
			return "login";
		}

	}

	/**
	 * ǰ̨��¼
	 * 
	 * @return
	 */
	@RequestMapping(value = "dologin.html")
	public String baklogin(@RequestParam("admin") String admin,
			@RequestParam("pwds") String pwds, HttpServletRequest request,
			HttpSession session) throws Exception {

		User user = userService.loginuser(admin, pwds);
		if (null != user) {// ��¼�ɹ�
			// ����session
			session.setAttribute(Constants.USER_SESSION, user);
			// ҳ����ת��frame.jsp��
			return "redirect:/sys/index.html";
		} else {
			// ҳ����ת��login.jsp��������ʾ��Ϣ--ת��
			request.setAttribute("error", "�û��������벻��ȷ");
			return "login";
		}

	}

}
