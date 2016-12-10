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
public class OvertimeController {

	private static final String ACTION_BASE_URL_HEADER = "overtime";
	@Autowired
	OvertimeDao overtimeMapper;

	/**
	 * 加班审核
	 * @param request
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/OvertimeCheck.do", method = RequestMethod.GET)
	@ResponseBody
	public Object OvertimeCheck(HttpServletRequest request) 
	{
		int status = Status.ACTION_SUCCESS;
		
		List<Overtime> overtime;
		overtime = overtimeMapper.selectOvertimeCheck();

		return new Response(status, overtime);
	}
	/**
	 * 审核 查看详情
	 * @param request
	 * @param oId
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/OvertimeCheckDetail.do", method = RequestMethod.POST)
	@ResponseBody
	public Object OvertimeCheckDetail(HttpServletRequest request,@RequestParam int oId) 
	{
		int status = Status.ACTION_SUCCESS;
		
		Overtime students=new Overtime();
		students = overtimeMapper.selectOvertimeCheckDetail(oId);

		return new Response(status,students);
	}
		/**
		 * 查询加班审核状态
		 * @param request
		 * @param oId
		 * @return
		 */
		@RequestMapping(value = ACTION_BASE_URL_HEADER + "/OvertimeStatus.do", method = RequestMethod.POST)
		@ResponseBody
		public Object OvertimeStatus(HttpServletRequest request,@RequestParam int oId) 
		{
			int status = Status.ACTION_SUCCESS;
			
			Overtime students=new Overtime();
			students = overtimeMapper.selectOvertimeState(oId);

			return new Response(status, students);
		}
		
		/**
		 * 加班申请
		 * @param request
		 * @param Overtime
		 * @return
		 */
		@RequestMapping(value = ACTION_BASE_URL_HEADER + "/OvertimeApply.do", method = RequestMethod.POST)
		@ResponseBody
		public Object OvertimeApply(HttpServletRequest request,@RequestBody Overtime overtime) 
		{
			int status = Status.ACTION_SUCCESS;
			Overtime ot=overtime;
			overtimeMapper.saveOvertimeApply(ot);
			return new Response(status,ot.getoName());
		}
		/**
		 * 加班审批
		 * @param request
		 * @param Overtime
		 * @return
		 */
		@RequestMapping(value = ACTION_BASE_URL_HEADER + "/OvertimeApprove.do", method = RequestMethod.POST)
		@ResponseBody
		public Object OvertimeApprove(HttpServletRequest request,@RequestBody Overtime overtime) 
		{
			int status = Status.ACTION_SUCCESS;
			Overtime to=overtime;
			overtimeMapper.saveOvertimeApprove(to);
			return new Response(status,to.getoApproveState());
		}
		/**
		 * 加班审批列表 
		 * @param request
		 * @return
		 */
		@RequestMapping(value = ACTION_BASE_URL_HEADER + "/OvertimeApproveList.do", method = RequestMethod.GET)
		@ResponseBody
		public Object OvertimeApproveList(HttpServletRequest request) 
		{
			int status = Status.ACTION_SUCCESS;
			
			List<Overtime> overtime;
			overtime = overtimeMapper.selectOvertimeApproveList();

			return new Response(status, overtime);
		}
		/**
		 * 审批查看详情
		 * @param request
		 * @param oId
		 * @return
		 */
		@RequestMapping(value = ACTION_BASE_URL_HEADER + "/OvertimeApproveDetail.do", method = RequestMethod.POST)
		@ResponseBody
		public Object OvertimeApproveDetail(HttpServletRequest request,@RequestParam int oId) 
		{
			int status = Status.ACTION_SUCCESS;
			
			Overtime students=new Overtime();
			students = overtimeMapper.selectOvertimeApproveDetail(oId);

			return new Response(status,students);
		}
}
