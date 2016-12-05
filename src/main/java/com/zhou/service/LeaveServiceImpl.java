package com.zhou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhou.dao.LeaveDao;
import com.zhou.model.Leave;

@Service
public class LeaveServiceImpl implements LeaveService{

	@Autowired  
    private LeaveDao leaveDao;  

	public Leave selectLeaveState(String lNo)
	{  
        return leaveDao.selectLeaveState(lNo);  
    } 
	public Leave selectLeaveCheck(String lNo)
	{  
        return leaveDao.selectLeaveCheck(lNo);  
    } 
	public void saveLeaveApply(Leave leave)
	{  
		leaveDao.saveLeaveApply(leave);  
    } 
	public void saveLeaveApprove(Leave leave)
	{  
        leaveDao.saveLeaveApprove(leave);  
    } 
}
