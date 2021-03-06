package com.zhou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhou.dao.EmployeeDao;
import com.zhou.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired  
    private EmployeeDao employeeDao;  
	
	public void saveEmp(Employee employee)
	{
		employeeDao.saveEmp(employee);
	}
	public List<Employee> findAllEmp()
	{
		return employeeDao.findAllEmp();
	}
    public List<Employee> selectEmpById(String eNo)
    {
    	return employeeDao.selectEmpById(eNo);
    }
    public void updateEmp(Employee employee)
    {
    	employeeDao.updateEmp(employee);
    }
    public void updatePwd(Employee employee)
    {
    	employeeDao.updatePwd(employee);
    }
    public void deleteEmp(String eNo)
    {
    	employeeDao.deleteEmp(eNo);
    }
}
