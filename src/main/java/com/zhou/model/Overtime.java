package com.zhou.model;

import java.util.Date;

public class Overtime {
	private Integer oId;  
    private String oNo;  
    private String oName;
    private String oReason;
    private Date oStartTime;
    private Date oEndTime;
    private Date oApplyTime;  
    private Date oApproveTime;
    private Integer oApproveState;
    private String oApproveAdvice; 
    private Integer oApprovePass; 
    private String oApprover;
	public Integer getoId() {
		return oId;
	}
	public void setoId(Integer oId) {
		this.oId = oId;
	}
	public String getoNo() {
		return oNo;
	}
	public void setoNo(String oNo) {
		this.oNo = oNo;
	}
	public String getoName() {
		return oName;
	}
	public void setoName(String oName) {
		this.oName = oName;
	}
	public String getoReason() {
		return oReason;
	}
	public void setoReason(String oReason) {
		this.oReason = oReason;
	}
	public Date getoStartTime() {
		return oStartTime;
	}
	public void setoStartTime(Date oStartTime) {
		this.oStartTime = oStartTime;
	}
	public Date getoEndTime() {
		return oEndTime;
	}
	public void setoEndTime(Date oEndTime) {
		this.oEndTime = oEndTime;
	}
	public Date getoApplyTime() {
		return oApplyTime;
	}
	public void setoApplyTime(Date oApplyTime) {
		this.oApplyTime = oApplyTime;
	}
	public Date getoApproveTime() {
		return oApproveTime;
	}
	public void setoApproveTime(Date oApproveTime) {
		this.oApproveTime = oApproveTime;
	}
	public Integer getoApproveState() {
		return oApproveState;
	}
	public void setoApproveState(Integer oApproveState) {
		this.oApproveState = oApproveState;
	}
	public String getoApproveAdvice() {
		return oApproveAdvice;
	}
	public void setoApproveAdvice(String oApproveAdvice) {
		this.oApproveAdvice = oApproveAdvice;
	}
	public Integer getoApprovePass() {
		return oApprovePass;
	}
	public void setoApprovePass(Integer oApprovePass) {
		this.oApprovePass = oApprovePass;
	}
	public String getoApprover() {
		return oApprover;
	}
	public void setoApprover(String oApprover) {
		this.oApprover = oApprover;
	}
    
    
}
