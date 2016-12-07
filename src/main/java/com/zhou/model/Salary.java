package com.zhou.model;

import java.util.Date;
import com.zhou.model.Employee;

public class Salary {
	private Integer sId;  
    private String sNo;  
    private String sName;
    private Employee employee;
    private Integer sBasic;
    private Integer sLeaveNo;
    private Integer sOvertimeNo;
    private Integer sReal;  
    private Date sDate;
    private String sBeizhu;
    
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Integer getsBasic() {
		return sBasic;
	}
	public void setsBasic(Integer sBasic) {
		this.sBasic = sBasic;
	}
	public Integer getsLeaveNo() {
		return sLeaveNo;
	}
	public void setsLeaveNo(Integer sLeaveNo) {
		this.sLeaveNo = sLeaveNo;
	}
	public Integer getsOvertimeNo() {
		return sOvertimeNo;
	}
	public void setsOvertimeNo(Integer sOvertimeNo) {
		this.sOvertimeNo = sOvertimeNo;
	}
	public Integer getsReal() {
		return sReal;
	}
	public void setsReal(Integer sReal) {
		this.sReal = sReal;
	}
	public Date getsDate() {
		return sDate;
	}
	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}
	public String getsBeizhu() {
		return sBeizhu;
	}
	public void setsBeizhu(String sBeizhu) {
		this.sBeizhu = sBeizhu;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
    
    
}
