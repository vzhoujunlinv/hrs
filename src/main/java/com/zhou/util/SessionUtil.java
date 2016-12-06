package com.zhou.util;

import com.zhou.model.Employee;
import com.zhou.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Rick  E-mail: maodai1990@163.com
 * @version 创建时间：2014-5-16 上午10:06:55
 * 类说明
 */
public class SessionUtil {
	
	private static final String LOGIN_STAFF = "LOGIN_STAFF";
	private static final String LOGIN_EMP = "LOGIN_EMP";

	public static void setLoginUser(HttpServletRequest request, User user){
		request.getSession().setAttribute(LOGIN_STAFF, user);
	}

	public static User getLoginUser(HttpServletRequest request){
		return (User)request.getSession().getAttribute(LOGIN_STAFF);
	}
	
	public static void setLoginEmp(HttpServletRequest request, Employee emp){
		request.getSession().setAttribute(LOGIN_EMP, emp);
	}

	public static Employee getLoginEmp(HttpServletRequest request){
		return (Employee)request.getSession().getAttribute(LOGIN_EMP);
	}

	public static void removeSession(HttpServletRequest request, User user){
		request.getSession().removeAttribute(user.getUserName());
		request.getSession().invalidate();
	}
	
	public static void removeEmpSession(HttpServletRequest request, Employee emp){
		request.getSession().removeAttribute(emp.geteName());
		request.getSession().invalidate();
	}
}
 