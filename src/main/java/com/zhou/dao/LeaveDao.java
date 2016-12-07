package com.zhou.dao;

import java.util.List;

import com.zhou.model.Leave;

public interface LeaveDao {


    /**
     * @param none
     * @return LeaveState
     */
    public Leave selectLeaveState(String lNo);  
    public Leave selectLeaveCheck(String lNo);
    List<Leave> selectLeaveCheck();
    
    void saveLeaveApprove(Leave leave);
    void saveLeaveApply(Leave leave);
    
    //Leave findById(String lNo);   //查 
    //List<Leave> findAll();    
}
