package com.zhou.dao;

import java.util.List;

import com.zhou.model.Salary;
import com.zhou.model.Employee;


import com.zhou.model.SalaryDetail;


public interface SalaryDao {
   
    public List<Salary> GetSalaryList(String eNo);
    
    public List<Salary> GetSalaryByDep(Employee employee);
    
    public List<SalaryDetail> GetSalaryDetail(String eNo);
   
    public Salary ComputeSal(int eDepartment);
    
    public int AddSal(Salary salary);

}
