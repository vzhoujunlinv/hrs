package com.zhou.model;

import java.util.Date;

public class Leave {
	private Integer lId;  
    private String lNo;	  
    private String lName;
    private String lReason;
    private String lStartTime;
    private String lEndTime;
    private String lApplyTime;  
    private String lApproveTime;
    private Integer lApproveState;
    private String lApproveAdvice; 
    private Integer lApprovePass; 
    private String lApprover;
	public Integer getlId() {
		return lId;
	}
	public void setlId(Integer lId) {
		this.lId = lId;
	}
	public String getlNo() {
		return lNo;
	}
	public void setlNo(String lNo) {
		this.lNo = lNo;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getlReason() {
		return lReason;
	}
	public void setlReason(String lReason) {
		this.lReason = lReason;
	}
	public String getlStartTime() {
		return lStartTime;
	}
	public void setlStartTime(String lStartTime) {
		this.lStartTime = lStartTime;
	}

	public Integer getlApproveState() {
		return lApproveState;
	}
	public void setlApproveState(Integer lApproveState) {
		this.lApproveState = lApproveState;
	}
	public String getlApproveAdvice() {
		return lApproveAdvice;
	}
	public void setlApproveAdvice(String lApproveAdvice) {
		this.lApproveAdvice = lApproveAdvice;
	}
	public Integer getlApprovePass() {
		return lApprovePass;
	}
	public void setlApprovePass(Integer lApprovePass) {
		this.lApprovePass = lApprovePass;
	}
	public String getlApprover() {
		return lApprover;
	}
	public void setlApprover(String lApprover) {
		this.lApprover = lApprover;
	}
	/*public Leave(String lNo,String lName,String lReason, Date lStartTime,Date lEndTime, Date lApplyTime)
	{
		this.lNo=lNo;
		this.lName=lName;
		this.lReason=lReason;
		this.lStartTime=lStartTime;
		this.lEndTime=lEndTime;
		this.lApplyTime=lApplyTime;
	}
	public Leave(Date lApproveTime,Integer lApproveState,String lApproveAdvice,Integer lApprovePass,String lApprover)
	{
		this.lApproveTime=lApproveTime;
		this.lApproveState=lApproveState;
		this.lApproveAdvice=lApproveAdvice;
		this.lApprovePass=lApprovePass;
		this.lApprover=lApprover;
	}*/
	public String getlEndTime() {
		return lEndTime;
	}
	public void setlEndTime(String lEndTime) {
		this.lEndTime = lEndTime;
	}
	public String getlApproveTime() {
		return lApproveTime;
	}
	public void setlApproveTime(String lApproveTime) {
		this.lApproveTime = lApproveTime;
	}
	public String getlApplyTime() {
		return lApplyTime;
	}
	public void setlApplyTime(String lApplyTime) {
		this.lApplyTime = lApplyTime;
	}
		
	
    
}
