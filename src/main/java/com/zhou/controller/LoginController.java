package com.zhou.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.zhou.common.Response;
import com.zhou.common.Status;
import com.zhou.dao.*;
import com.zhou.exception.*;
import com.zhou.model.*;
import com.zhou.service.*;
import com.zhou.util.SessionUtil;
import com.zhou.validator.EmployeeAddValidator;

@Controller
public class LoginController {
	
	private static final String ACTION_BASE_URL_HEADER = "/employee";
	@Autowired
	LoginDao loginMapper;
	@Autowired
    private LoginService loginService;
	
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/login.do",method = RequestMethod.POST)
    @ResponseBody
    public Object loginEmployee(@RequestParam("eName")String eName, @RequestParam("password")String ePwd,HttpServletRequest request){
        int status;
        Employee emp = null;
        try {
        	emp = loginService.loginEmployee(eName, ePwd);
            status = emp.getRole();
        } catch (NotExistException e) {
            e.printStackTrace();
            status = Status.NOT_EXIXTS;
        } catch (PasswordNotMatchException e) {
            e.printStackTrace();
            status = Status.PASSWORD_NOT_CORRECT;
        }
        SessionUtil.setLoginEmp(request,emp);
        return new Response(status, emp);
    }
	
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/logout.do",method = RequestMethod.POST)
    @ResponseBody
    public Object logout(HttpServletRequest request, @Validated({EmployeeAddValidator.class})@RequestBody Employee emp){
        int status = Status.ACTION_SUCCESS;
        SessionUtil.removeEmpSession(request, emp);
        return new Response(status);
    }
	
	/**
	 * 返回员工信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/showOneEmp.do",method = RequestMethod.POST)
    @ResponseBody
    public Object showOneEmp(@RequestParam int id) throws UnknownException{
        int status = Status.ACTION_SUCCESS;
        Employee emp = new Employee();
        emp = loginService.showOneEmp(id);
		if( emp == null){
		    status = Status.NO_RECORDS;
		}
        return new Response(status,emp);
    }
}
