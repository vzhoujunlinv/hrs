package com.zhou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhou.dao.LoginDao;
import com.zhou.exception.NotExistException;
import com.zhou.exception.PasswordNotMatchException;
import com.zhou.model.Employee;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired  
    private LoginDao loginDao;  
	
	@Override
	public Employee loginEmployee(String eNo, String ePwd)
			throws NotExistException, PasswordNotMatchException {
		// TODO Auto-generated method stub
		Employee emp = loginDao.loginEmployee(eNo);
		if(emp == null){
            throw new NotExistException("Employee:"+eNo+" not exists");
        }else{
            String encryptPassword = emp.getePwd();
            if(!encryptPassword.equals(ePwd)){
            	//System.out.println(user.getUserName()+user.getUserPassword()+":");
                throw new PasswordNotMatchException();
            }
        }
        return emp;
	}

	@Override
	public Employee showOneEmp(int id) {
		// TODO Auto-generated method stub
		return loginDao.showOneEmp(id);
	}

	
}
