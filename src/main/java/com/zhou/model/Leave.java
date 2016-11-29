package com.zhou.model;

import java.util.Date;

public class Leave {
	private Integer lId;  
    private String lNo;  
    private String lName;
    private String lReason;
    private Date lStartTime;
    private Date lEndTime;
    private Date lApplyTime;  
    private Date lApproveTime;
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
	public Date getlStartTime() {
		return lStartTime;
	}
	public void setlStartTime(Date lStartTime) {
		this.lStartTime = lStartTime;
	}
	public Date getlEndTime() {
		return lEndTime;
	}
	public void setlEndTime(Date lEndTime) {
		this.lEndTime = lEndTime;
	}
	public Date getlApplyTime() {
		return lApplyTime;
	}
	public void setlApplyTime(Date lApplyTime) {
		this.lApplyTime = lApplyTime;
	}
	public Date getlApproveTime() {
		return lApproveTime;
	}
	public void setlApproveTime(Date lApproveTime) {
		this.lApproveTime = lApproveTime;
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
    
    
}
