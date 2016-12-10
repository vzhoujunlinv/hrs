package com.zhou.dao;

import java.util.List;

import com.zhou.model.Leave;


public interface LeaveDao {


    /**
     * @param none
     * @return LeaveState
     */
	//查看审批状态
    public Leave selectLeaveState(String lId);
    //请假审核：显示请假列表
    List<Leave> selectLeaveCheck();
    //请假审核：查看详情
    public Leave selectLeaveStateDetail(String lId);  
    //请假审批
    void saveLeaveApprove(Leave leave);
    //请假审批：查看理由
    public Leave selectLeaveApproveDetail(String lId);
    //请假审批：显示列表
    List<Leave> selectLeaveApproveList();
    //请假申请
    void saveLeaveApply(Leave leave);
    
}
