package com.zhou.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zhou.model.Overtime;

public interface OvertimeService {
	    //public Overtime selectOvertimeState(int oNo);  

		//public Overtime selectOvertimeState(int oId);  
	    public List<Overtime> selectOvertimeCheck();
	    
	    void saveOvertimeApprove(Overtime overtime);
	    void saveOvertimeApply(Overtime overtime);
}
