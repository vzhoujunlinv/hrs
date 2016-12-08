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
public class DepartmentController {
	private static final String ACTION_BASE_URL_HEADER = "department";
	@Autowired
	DepartmentDao departmentMapper;
	
	/**
	 * 查询所有部门
	 * @param request
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/selAllDep.do", method = RequestMethod.GET)
	@ResponseBody
	public Object selAllDep(HttpServletRequest request) 
	{
		int status = Status.ACTION_SUCCESS;
		
		List<Department> students;
		students = departmentMapper.findAllDep();
		return new Response(status, students);
	}
	/**
	 * 添加部门
	 * @param request
	 * @param Department
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/AddDep.do", method = RequestMethod.POST)
	@ResponseBody
	public Object saveDep(HttpServletRequest request,@RequestBody Department department) 
	{
		int status = Status.ACTION_SUCCESS;
		Department dep=department;
		departmentMapper.saveDep(dep);
		return new Response(status,dep.getdName());
	}
	/**
	 * 修改部门
	 * @param request
	 * @param Department
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/updateDep.do", method = RequestMethod.POST)
	@ResponseBody
	public Object updateDep(HttpServletRequest request,@RequestBody Department department) 
	{
		int status = Status.ACTION_SUCCESS;
		Department dep=department;
		departmentMapper.updateDep(dep);
		return new Response(status,dep.getdState());
	}
}
