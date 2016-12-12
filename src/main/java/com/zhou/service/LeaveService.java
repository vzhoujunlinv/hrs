package com.zhou.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zhou.model.Leave;

public interface LeaveService {
	 //Leave selectLeaveState(String lNo);

	    //public Leave selectLeaveState(String lNo);  

	    public List<Leave> selectLeaveCheck();

	    
	    
	    void saveLeaveApprove(Leave leave);
	    void saveLeaveApply(Leave leave);
}
