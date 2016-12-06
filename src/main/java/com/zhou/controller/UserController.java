package com.zhou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.zhou.common.Response;
import com.zhou.common.Status;
import com.zhou.dao.*;
import com.zhou.exception.*;
import com.zhou.model.*;
import com.zhou.service.*;
import com.zhou.util.SessionUtil;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@Controller
public class UserController {

	private static final String ACTION_BASE_URL_HEADER = "/user";
	@Autowired
	UserDao userMapper;
	@Autowired
    private UserService userService;

	/**
	 * 查询所有学生
	 * @param request
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/findAll.do", method = RequestMethod.GET)
	@ResponseBody
	public Object findAll(HttpServletRequest request) {
		int status = Status.ACTION_SUCCESS;
		
		//List<User> students;
		//students = userMapper.queryAllUser();
		saveLeaveApprove(Leave leave)
		return new Response(status, students);
	}
	
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/login.do",method = RequestMethod.POST)
    @ResponseBody
    public Object loginUser(@RequestParam("loginName")String userName, @RequestParam("password")String password,HttpServletRequest request){
        int status;
        User user = null;
        try {
        	user = userService.loginUser(userName,password);
            status = user.getUserRole();
        } catch (NotExistException e) {
            e.printStackTrace();
            status = Status.NOT_EXIXTS;
        } catch (PasswordNotMatchException e) {
            e.printStackTrace();
            status = Status.PASSWORD_NOT_CORRECT;
        }
        SessionUtil.setLoginUser(request,user);
        return new Response(status, user);
    }
}