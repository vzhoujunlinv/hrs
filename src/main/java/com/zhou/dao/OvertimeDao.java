package com.zhou.dao;

import java.util.List;

import com.zhou.model.Overtime;

public interface OvertimeDao {
	//查看加班审批状态
	List<Overtime> selectOvertimeState(String oNo);
    //加班审核查看详情
    public Overtime selectOvertimeStateDetail(int oId);
    //加班审核列表
    List<Overtime> selectOvertimeCheck();
    //加班审核查看详情
    public Overtime selectOvertimeCheckDetail(int oId);
    //加班审批
    void saveOvertimeApprove(Overtime overtime);
    //加班审批列表
    List<Overtime> selectOvertimeApproveList();
    //根据部门显示加班审批列表
    List<Overtime> selectOvertimeApproveListByDep(String eDepartment);
    //加班审批查看详情
    public Overtime selectOvertimeApproveDetail(int oId);
    //加班申请
    void saveOvertimeApply(Overtime overtime);
}
