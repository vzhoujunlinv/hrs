package com.zhou.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.zhou.exception.NotExistException;
import com.zhou.exception.PasswordNotMatchException;
import com.zhou.model.Employee;

public interface LoginService {
	
	@Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
    Employee loginEmployee(String eName, String ePwd) throws NotExistException, PasswordNotMatchException;

	Employee showOneEmp(int id);
}
