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
		 * 查询请假审核状态
		 * @param request
		 * @param lNo
		 * @return
		 */
		@RequestMapping(value = ACTION_BASE_URL_HEADER + "/LeaveStatus.do", method = RequestMethod.POST)
		@ResponseBody
		public Object LeaveStatus(HttpServletRequest request,@RequestParam String lId) 
		{
			int status = Status.ACTION_SUCCESS;
			
			Leave students=new Leave();
			students = leaveMapper.selectLeaveState(lId);

			return new Response(status, students);
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
}