package com.zhou.service;

import java.util.List;


import com.zhou.model.Salary;
import com.zhou.model.SalaryDetail;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.zhou.exception.*;
import com.zhou.model.Salary;
import com.zhou.model.Employee;
import com.zhou.model.SalaryDetail;

public interface SalaryService {
    public List<Salary> GetSalaryList(String eNo);
    
    public List<Salary> GetSalaryByDep(Employee employee);
   
    public List<SalaryDetail> GetSalaryDetail(String eNo);
   
    public int SetSalary(int eDepartment);  
    
    public Salary ComputeSal(int eDepartment);
 
}
