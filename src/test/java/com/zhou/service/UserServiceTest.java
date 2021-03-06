package com.zhou.service;

import org.junit.Test;  
import org.springframework.beans.factory.annotation.Autowired;  

import com.zhou.baseTest.SpringTestCase;  
import com.zhou.exception.NotExistException;
import com.zhou.exception.PasswordNotMatchException;
import com.zhou.model.Employee;
import com.zhou.model.User;

public class UserServiceTest extends SpringTestCase {

    @Autowired  
    private UserService userService; 
    @Autowired  
    private LoginService LoginService; 

    @Test  
    public void selectUserByIdTest() throws NotExistException, PasswordNotMatchException{  
//        User user = userService.selectUserById(2);  
        User user = userService.loginUser("zhou", "123456");  
        System.out.println(user.getUserName() + ":" + user.getUserPassword());
        
        Employee emp = LoginService.loginEmployee("BigZhou", "123");
        System.out.println(emp.geteName() + ":" + emp.getePwd());
    }  
}