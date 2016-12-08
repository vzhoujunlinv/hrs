package com.zhou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhou.dao.SalaryDao;
import com.zhou.model.Salary;
import com.zhou.model.SalaryDetail;

@Service
public class SalaryServiceImpl implements SalaryService{
    @Autowired  
    private SalaryDao SalaryDao; 

	@Override
	public List<Salary> GetSalaryList(String eNo) {
		return SalaryDao.GetSalaryList(eNo);
	}

	@Override
	public List<SalaryDetail> GetSalaryDetail(String eNo) {
		return SalaryDao.GetSalaryDetail(eNo);
	}

	@Override
	public int SetSalary(String eDepartment) {
		Salary salary1=SalaryDao.ComputeSal(eDepartment);
    	return SalaryDao.AddSal(salary1);
	}

}