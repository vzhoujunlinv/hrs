package com.zhou.dao;

import java.util.List;

import com.zhou.model.Salary;

import com.zhou.model.SalaryDetail;


public interface SalaryDao {
   
    public List<Salary> GetSalaryList(String eNo);
    
    public List<SalaryDetail> GetSalaryDetail(String eNo);
   
    public Salary ComputeSal(String eDepartment);
    
    public int AddSal(Salary salary);

}
