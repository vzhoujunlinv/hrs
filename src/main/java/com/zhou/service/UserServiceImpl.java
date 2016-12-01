package com.zhou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhou.dao.UserDao;
import com.zhou.exception.*;
import com.zhou.model.User;
import com.zhou.util.EncryptionUtil;

@Service  
public class UserServiceImpl implements UserService {

    @Autowired  
    private UserDao userDao;  
    
    public User selectUserById(Integer userId) {  
        return userDao.selectUserById(userId);  

    }

    @Override
    public User loginUser(String userName, String password) throws NotExistException, PasswordNotMatchException {
        User user = userDao.loginUser(userName);
        if(user == null){
            throw new NotExistException("user:"+userName+" not exists");
        }else{
            String encryptPassword = user.getUserPassword();
            if(!encryptPassword.equals(password)){
            	//System.out.println(user.getUserName()+user.getUserPassword()+":");
                throw new PasswordNotMatchException();
            }
        }
        return user;
    }


}