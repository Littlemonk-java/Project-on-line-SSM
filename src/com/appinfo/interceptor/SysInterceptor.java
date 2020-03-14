package com.appinfo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.appinfo.pojo.User;
import com.appinfo.tools.Constants;

/**
 * ҳ��������  �ж��Ƿ���?
 * @author Waitforyou
 * http://blog.csdn.net/liuwenbo0920/article/details/7283757
 */
public class SysInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = Logger.getLogger(SysInterceptor.class);
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		logger.debug("SysInterceptor preHandle ==========================������");
		HttpSession session = request.getSession(); 
		
		User user = (User)session.getAttribute(Constants.USER_SESSION);
		
		if(null == user){
			response.sendRedirect(request.getContextPath()+"/403.jsp");
			return false;
		}
		return true;
	}
}
