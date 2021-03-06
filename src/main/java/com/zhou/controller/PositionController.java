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
public class PositionController {
	private static final String ACTION_BASE_URL_HEADER = "position";
	@Autowired
	PositionDao positionMapper;
	
	/**
	 * 查询所有部门
	 * @param request
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/selAllPos.do", method = RequestMethod.GET)
	@ResponseBody
	public Object selAllPos(HttpServletRequest request) 
	{
		int status = Status.ACTION_SUCCESS;
		
		List<Position> students;
		students = positionMapper.findAllPos();
		return new Response(status, students);
	}
	/**
	 * 添加部门
	 * @param request
	 * @param Position
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/AddPos.do", method = RequestMethod.POST)
	@ResponseBody
	public Object savePos(HttpServletRequest request,@RequestBody Position position) 

	{
		int status = Status.ACTION_SUCCESS;
		Position pos=position;
		positionMapper.savePos(pos);
		return new Response(status,pos.getpName());
	}
	/**
	 * 修改部门
	 * @param request
	 * @param Position
	 * @return
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/updatePos.do", method = RequestMethod.POST)
	@ResponseBody
	public Object updatePos(HttpServletRequest request,@RequestBody Position position) 

	{
		int status = Status.ACTION_SUCCESS;
		Position pos=position;
		positionMapper.updatePos(pos);
		return new Response(status,pos.getpName());
	}
	/**
	 * 删除职称
	 */
	@RequestMapping(value = ACTION_BASE_URL_HEADER + "/deletePos.do",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteTask(@RequestParam("pId") int pId){
        int status = Status.ACTION_SUCCESS;
        positionMapper.deletePos(pId);
        return new Response(status,pId);
    }
}
