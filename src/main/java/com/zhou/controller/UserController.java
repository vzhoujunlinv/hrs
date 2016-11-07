package com.zhou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.zhou.common.Response;
import com.zhou.common.Status;
import com.zhou.dao.*;
import com.zhou.model.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

	private static final String ACTION_BASE_URL_HEADER = "user";
	@Autowired
	UserDao userMapper;

	/**
	 * 查询所有学生
	 * @param request
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/findAll.do", method = RequestMethod.GET)
	@ResponseBody
	public Object findAll(HttpServletRequest request) {
		int status = Status.ACTION_SUCCESS;
		
		List<User> students;
		students = userMapper.queryAllUser();

		return new Response(status, students);
	}
}