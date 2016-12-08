package com.zhou.dao;

import java.util.List;

import com.zhou.model.Overtime;

public interface OvertimeDao {
	
    public Overtime selectOvertimeState(String oId);  
    List<Overtime> selectOvertimeCheck();
    
    void saveOvertimeApprove(Overtime overtime);
    void saveOvertimeApply(Overtime overtime);
}
