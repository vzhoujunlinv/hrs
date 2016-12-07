package com.zhou.model;


public class SalaryDetail {
	private String eNo;
	private Integer lno;
	private Integer ono;
	private Integer minus;
	private Integer plus;
	private Leave leave;
	private Overtime overtime;
	
	public String geteNo() {
		return eNo;
	}
	public void seteNo(String eNo) {
		this.eNo = eNo;
	}
	public Integer getlno() {
		return lno;
	}
	public void setlno(Integer lno) {
		this.lno = lno;
	}
	public Integer getono() {
		return ono;
	}
	public void setono(Integer ono) {
		this.ono = ono;
	}
	public Integer getMinus() {
		return minus;
	}
	public void setMinus(Integer minus) {
		this.minus = minus;
	}
	public Integer getPlus() {
		return plus;
	}
	public void setPlus(Integer plus) {
		this.plus = plus;
	}
	public Leave getLeave() {
		return leave;
	}
	public void setLeave(Leave leave) {
		this.leave = leave;
	}
	public Overtime getOvertime() {
		return overtime;
	}
	public void setOvertime(Overtime overtime) {
		this.overtime = overtime;
	}

}
