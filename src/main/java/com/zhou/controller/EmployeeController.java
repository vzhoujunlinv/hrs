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
public class EmployeeController {
	private static final String ACTION_BASE_URL_HEADER = "leave";
	@Autowired
	EmployeeDao employeeMapper;
	
	/**
	 * 查询单个员工
	 * @param request
	 * @param eNo
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/selEmpById.do", method = RequestMethod.GET)
	@ResponseBody
	public Object LeaveCheck(HttpServletRequest request,Employee employee) 
	{
		int status = Status.ACTION_SUCCESS;
		Employee students;
		students = employeeMapper.selectEmpById(employee.geteNo());
		return new Response(status, students);
	}
	/**
	 * 查询所有员工
	 * @param request
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/selAllEmp.do", method = RequestMethod.GET)
	@ResponseBody
	public Object LeaveCheck(HttpServletRequest request) 
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
	public Object LeaveApply(HttpServletRequest request,Employee employee) 
	{
		int status = Status.ACTION_SUCCESS;
		employeeMapper.saveEmp(employee);
		return new Response(status);
	}
	/**
	 * 修改员工资料
	 * @param request
	 * @param Employee
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/updateEmp.do", method = RequestMethod.POST)
	@ResponseBody
	public Object LeaveApply(HttpServletRequest request,Employee employee) 
	{
		int status = Status.ACTION_SUCCESS;
		employeeMapper.updateEmp(employee);
		return new Response(status);
	}
	/**
	 * 修改员工密码
	 * @param request
	 * @param eNo,ePwd
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/updatePwd.do", method = RequestMethod.POST)
	@ResponseBody
	public Object LeaveApply(HttpServletRequest request,Employee employee) 
	{
		int status = Status.ACTION_SUCCESS;
		employeeMapper.updatePwd(employee.getePwd(), employee.geteNo());
		return new Response(status);
	}
	/**
	 * 删除员工
	 * @param request
	 * @param eNo
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/deleteEmp.do", method = RequestMethod.POST)
	@ResponseBody
	public Object LeaveApply(HttpServletRequest request,Employee employee) 
	{
		int status = Status.ACTION_SUCCESS;
		employeeMapper.deleteEmp( employee.geteNo());
		return new Response(status);
	}
}
