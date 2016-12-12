package com.zhou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.zhou.common.Response;
import com.zhou.common.Status;
import com.zhou.dao.*;
import com.zhou.model.*;
import com.zhou.validator.EmployeeAddValidator;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@Controller
public class EmployeeController {
	private static final String ACTION_BASE_URL_HEADER = "employee";
	@Autowired
	EmployeeDao employeeMapper;
	
	/**
	 * 由员工编号查询
	 * @param request
	 * @param eNo
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/selEmpById.do", method = RequestMethod.POST)
	@ResponseBody
	public Object selEmpById(HttpServletRequest request,@RequestParam String eNo) 
	{
		int status = Status.ACTION_SUCCESS;
		
		List<Employee> students;
		students = employeeMapper.selectEmpById(eNo);
		return new Response(status, students);
	}
	/**
	 * 由部门查询
	 * @param request
	 * @param eDepartment
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/selEmpByDep.do", method = RequestMethod.POST)
	@ResponseBody
	public Object selEmpByDep(HttpServletRequest request,@RequestParam String eDepartment) 
	{
		int status = Status.ACTION_SUCCESS;
		
		List<Employee> students;
		students = employeeMapper.selectEmpByDep(eDepartment);
		return new Response(status, students);
	}
	/**
	 * 查询所有员工
	 * @param request
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/selAllEmp.do", method = RequestMethod.GET)
	@ResponseBody
	public Object selAllEmp(HttpServletRequest request) 
	{
		int status = Status.ACTION_SUCCESS;
		
		List<Employee> students;
		students = employeeMapper.findAllEmp();
		return new Response(status, students);
	}
	/**
	 * 添加员工
	 * @param request
	 * @param Employee
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/AddEmp.do", method = RequestMethod.POST)
	@ResponseBody
	public Object saveEmp(HttpServletRequest request,@Validated({EmployeeAddValidator.class})@RequestBody Employee employee) 

	{
		int status = Status.ACTION_SUCCESS;
		Employee emp = employee;
		employeeMapper.saveEmp(employee);
		return new Response(status,emp.geteName());
	}
	/**
	 * 修改员工资料
	 * @param request
	 * @param Employee
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/updateEmp.do", method = RequestMethod.POST)
	@ResponseBody
	public Object updateEmp(HttpServletRequest request,@RequestBody Employee employee) 

	{
		int status = Status.ACTION_SUCCESS;
		Employee emp = employee;
		employeeMapper.updateEmp(emp);
		return new Response(status,emp.geteNo());
	}
	/**
	 * 修改员工密码
	 * @param request
	 * @param eNo,ePwd
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/updatePwd.do", method = RequestMethod.POST)
	@ResponseBody
	public Object updatePwd(HttpServletRequest request,@RequestBody Employee employee) 

	{
		int status = Status.ACTION_SUCCESS;
		Employee emp = employee;
		employeeMapper.updatePwd(emp);
		return new Response(status,emp.geteNo());
	}
	/**
	 * 修改基本薪资
	 * @param request
	 * @param eNo,eBasicSalary
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/updateBs.do", method = RequestMethod.POST)
	@ResponseBody
	public Object updateBs(HttpServletRequest request,@RequestBody Employee employee) 
	{
		int status = Status.ACTION_SUCCESS;
		Employee emp = employee;
		employeeMapper.updateBs(emp);
		return new Response(status,emp.geteBasicSalary());
	}
	/**
	 * 删除员工
	 * @param request
	 * @param eNo
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/deleteEmp.do", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteEmp(HttpServletRequest request,@RequestParam("eNo")String eNo) 

	{
		int status = Status.ACTION_SUCCESS;
		employeeMapper.deleteEmp( eNo);
		return new Response(status);
	}
}
