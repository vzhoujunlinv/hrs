package com.zhou.service;

import java.util.List;

import com.zhou.model.Leave;

public interface LeaveService {
	 //Leave selectLeaveState(String lNo);

	    public Leave selectLeaveState(String lNo);  
	    public Leave selectLeaveCheck(String lNo);
	    List<Leave> selectLeaveCheck();
	    
	    void saveLeaveApprove(Leave leave);
	    void saveLeaveApply(Leave leave);
}
