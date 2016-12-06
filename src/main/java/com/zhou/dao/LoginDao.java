package com.zhou.dao;

import com.zhou.model.Employee;

public interface LoginDao {
	/**
	 * 
	 * @param eName
	 * @return Employee
	 * 登录
	 */
	Employee loginEmployee(String eName);
}
