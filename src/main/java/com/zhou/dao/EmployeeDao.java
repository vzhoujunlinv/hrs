package com.zhou.dao;

import java.util.List;

import com.zhou.model.Employee;

public interface EmployeeDao {
	/**
     * @param eNo
     * @return Employee
     */
    public void saveEmp(Employee employee);
    public Employee selectEmpById(String eNo);
    public List<Employee> findAllEmp();
    public void updateEmp(Employee employee);
    public void deleteEmp(String eNo);
    public void updatePwd(String ePwd,String eNo);
}
