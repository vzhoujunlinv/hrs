package com.zhou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.zhou.common.Response;
import com.zhou.common.Status;
import com.zhou.model.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import com.zhou.service.SalaryService;

@Controller  
public class SalaryController {
private static final String ACTION_BASE_URL_HEADER = "salary";
	
	@Autowired  
	private SalaryService SalaryService;  

	 /**  
     * 获取所有薪资列表  
     * @param request  
     * @return  
     */  
	 @RequestMapping(value = ACTION_BASE_URL_HEADER+"/GetSalaryList.do",method = RequestMethod.GET)
	    @ResponseBody
	    public Object getSalaryList(@RequestParam String eNo,HttpServletRequest request){
	        int status = Status.ACTION_SUCCESS;
	        List<Salary> salarys;
	        salarys = SalaryService.GetSalaryList(eNo);
	        if (salarys==null){
                status = Status.NO_RECORDS;
            }
	        return new Response(status,salarys);
	    }
	 
	 /**  
	     * 获取所有薪资细节  
	     * @param request  
	     * @return  
	     */  
		 @RequestMapping(value = ACTION_BASE_URL_HEADER+"/GetSalaryDetail.do",method = RequestMethod.GET)
		    @ResponseBody
		    public Object getSalaryDetail(@RequestParam String eNo,HttpServletRequest request){
		        int status = Status.ACTION_SUCCESS;
		        List<SalaryDetail> salarydets;
		        salarydets = SalaryService.GetSalaryDetail(eNo);
		        if (salarydets==null){
	                status = Status.NO_RECORDS;
	            }
		        return new Response(status,salarydets);
		    }		 
		 
		   @RequestMapping(value = ACTION_BASE_URL_HEADER+"/insert.do" ,method = RequestMethod.POST)
		    @ResponseBody
		    public Object insertSalary(HttpServletRequest request,
		                                 @RequestParam("eDepartment") String eDepartment){
		        int status = Status.ACTION_SUCCESS;
		        int flag=SalaryService.SetSalary(eDepartment);		        
		        if(flag==0){
		            status = Status.ACTION_FAIL;
		        }
		        return new Response(status);
		    }

}
