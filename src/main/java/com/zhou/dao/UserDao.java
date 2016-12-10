package com.zhou.dao;

import java.util.List;

import com.zhou.model.User;

public interface UserDao {

    /**
     * @param userId
     * @return User
     */
    public User selectUserById(Integer userId);  
    
    List<User> queryAllUser();

	public User loginUser(String userName);
    
    
}