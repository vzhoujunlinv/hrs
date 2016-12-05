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
		
		List<Leave> students;
		students = leaveMapper.selectLeaveCheck();

		return new Response(status, students);
	}
		/**
		 * 查询请假审核状态
		 * @param request
		 * @param lNo
		 * @return
		 */
		@RequestMapping(value = ACTION_BASE_URL_HEADER + "/LeaveStatus.do", method = RequestMethod.GET)
		@ResponseBody
		public Object LeaveStatus(HttpServletRequest request,Leave leave) 
		{
			int status = Status.ACTION_SUCCESS;
			
			//List<Leave> students;
			Leave students;
			students = leaveMapper.selectLeaveState(leave.getlNo());

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
		public Object LeaveApply(HttpServletRequest request,Leave leave) 
		{
			int status = Status.ACTION_SUCCESS;
			
			//List<Leave> students;
			//Leave students;
			//students = leaveMapper.selectLeaveState(leave.getlNo());
			leaveMapper.saveLeaveApply(leave);
			return new Response(status);
		}
		/**
		 * 请假审批
		 * @param request
		 * @param Leave
		 * @return
		 */
		@RequestMapping(value = ACTION_BASE_URL_HEADER + "/LeaveApprove.do", method = RequestMethod.POST)
		@ResponseBody
		public Object LeaveApply(HttpServletRequest request,Leave leave) 
		{
			int status = Status.ACTION_SUCCESS;
			
			//List<Leave> students;
			//Leave students;
			//students = leaveMapper.selectLeaveState(leave.getlNo());
			leaveMapper.saveLeaveApprove(leave);
			return new Response(status);
		}
}