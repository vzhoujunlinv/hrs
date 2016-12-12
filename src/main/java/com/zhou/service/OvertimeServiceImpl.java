package com.zhou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhou.dao.OvertimeDao;
import com.zhou.model.Overtime;

@Service
public class OvertimeServiceImpl implements OvertimeService{
	@Autowired  
    private OvertimeDao overtimeDao;  


	public Overtime selectOvertimeState(int oId)
	{  
        return overtimeDao.selectOvertimeState(oId);  
    } 
	public List<Overtime> selectOvertimeCheck()
	{  
        return overtimeDao.selectOvertimeCheck();  
    } 
	public void saveOvertimeApply(Overtime overtime)
	{  
		overtimeDao.saveOvertimeApply(overtime);  
    } 
	public void saveOvertimeApprove(Overtime overtime)
	{  
		overtimeDao.saveOvertimeApprove(overtime);  
    }

}
