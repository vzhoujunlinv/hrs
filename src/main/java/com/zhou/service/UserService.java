package com.zhou.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.zhou.exception.*;
import com.zhou.model.User;

public interface UserService {
    User selectUserById(Integer userId); 
    
    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
    User loginUser(String loginName, String password) throws NotExistException, PasswordNotMatchException;

}