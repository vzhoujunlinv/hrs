package com.zhou.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.zhou.common.Response;
import com.zhou.common.Status;
import com.zhou.dao.*;
import com.zhou.model.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@Controller
public class LeaveController {

	private static final String ACTION_BASE_URL_HEADER = "leave";
	@Autowired
	LeaveDao leaveMapper;

	/**
	 * 请假审核
	 * @param request
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/LeaveCheck.do", method = RequestMethod.GET)
	@ResponseBody
	public Object LeaveCheck(HttpServletRequest request) 
	{
		int status = Status.ACTION_SUCCESS;
		
		List<Leave> leaves;
		leaves = leaveMapper.selectLeaveCheck();

		return new Response(status, leaves);
	}
	/**
	 * 审核查看详情
	 * @param request
	 * @param lId
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/LeaveCheckDetail.do", method = RequestMethod.POST)
	@ResponseBody
	public Object LeaveCheckDetail(HttpServletRequest request,@RequestParam String lId) 
	{
		int status = Status.ACTION_SUCCESS;
		
		Leave leaves=new Leave();
		leaves = leaveMapper.selectLeaveStateDetail(lId);

		return new Response(status, leaves);
	}
		/**
		 * 查询请假审核状态
		 * @param request
		 * @param lId
		 * @return
		 */
		@RequestMapping(value = ACTION_BASE_URL_HEADER + "/LeaveStatus.do", method = RequestMethod.POST)
		@ResponseBody
		public Object LeaveStatus(HttpServletRequest request,@RequestParam String lId) 
		{
			int status = Status.ACTION_SUCCESS;
			
			Leave leaves=new Leave();
			leaves = leaveMapper.selectLeaveState(lId);

			return new Response(status, leaves);
		}
		
		/**
		 * 请假申请
		 * @param request
		 * @param Leave
		 * @return
		 */
		@RequestMapping(value = ACTION_BASE_URL_HEADER + "/LeaveApply.do", method = RequestMethod.POST)
		@ResponseBody
		public Object saveLeaveApply(HttpServletRequest request,@RequestBody Leave leave) 

		{
			int status = Status.ACTION_SUCCESS;
			Leave lv=leave;
			leaveMapper.saveLeaveApply(lv);
			return new Response(status,lv.getlName());
		}
		/**
		 * 请假审批
		 * @param request
		 * @param Leave
		 * @return
		 */
		@RequestMapping(value = ACTION_BASE_URL_HEADER + "/LeaveApprove.do", method = RequestMethod.POST)
		@ResponseBody
		public Object LeaveApply(HttpServletRequest request,@RequestBody Leave leave) 
		{
			int status = Status.ACTION_SUCCESS;
			Leave lv=leave;
			leaveMapper.saveLeaveApprove(lv);
			return new Response(status,lv.getlApproveState());
		}
		/**
		 * 请假审批列表
		 * @param request
		 * @return
		 */
		@RequestMapping(value = ACTION_BASE_URL_HEADER + "/LeaveApproveList.do", method = RequestMethod.GET)
		@ResponseBody
		public Object LeaveApproveList(HttpServletRequest request) 
		{
			int status = Status.ACTION_SUCCESS;
			
			List<Leave> leaves;
			leaves = leaveMapper.selectLeaveApproveList();

			return new Response(status, leaves);
		}
		/**
		 * 根据部门请假审批列表
		 * @param request
		 * @return
		 */
		@RequestMapping(value = ACTION_BASE_URL_HEADER + "/LeaveApproveListByDep.do", method = RequestMethod.POST)
		@ResponseBody
		public Object LeaveApproveListByDep(HttpServletRequest request,@RequestParam String eDepartment) 
		{
			int status = Status.ACTION_SUCCESS;
			
			List<Leave> leaves;
			leaves = leaveMapper.selectLeaveApproveListByDep(eDepartment);

			return new Response(status, leaves);
		}
		/**
		 * 审批查看详情
		 * @param request
		 * @param lId
		 * @return
		 */
		@RequestMapping(value = ACTION_BASE_URL_HEADER + "/LeaveApproveDetail.do", method = RequestMethod.POST)
		@ResponseBody
		public Object LeaveApproveDetail(HttpServletRequest request,@RequestParam String lId) 
		{
			int status = Status.ACTION_SUCCESS;
			
			Leave leaves=new Leave();
			leaves = leaveMapper.selectLeaveApproveDetail(lId);

			return new Response(status, leaves);
		}
}