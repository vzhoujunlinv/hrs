package com.zhou.model;

public class User {

    private Integer userId;  
    private String userName;  
    private String userPassword; 
    private Integer userRole;

    public Integer getUserId() {  
        return userId;  
    }  

    public void setUserId(Integer userId) {  
        this.userId = userId;  
    }  

    public String getUserName() {  
        return userName;  
    }  

    public void setUserName(String userName) {  
        this.userName = userName;  
    }  

    public String getUserPassword() {  
        return userPassword;  
    }  

    public void setUserPassword(String userPassword) {  
        this.userPassword = userPassword;  
    }

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	

}
