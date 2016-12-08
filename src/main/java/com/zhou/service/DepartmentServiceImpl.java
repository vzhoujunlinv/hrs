package com.zhou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhou.dao.DepartmentDao;
import com.zhou.model.Department;


@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired  
    private DepartmentDao departmentDao;  
	
	public void saveDep(Department department)
	{
		departmentDao.saveDep(department);
	}
	public List<Department> findAllDep()
	{
		return departmentDao.findAllDep();
	}
    public void updateDep(Department department)
    {
    	departmentDao.updateDep(department);
    }
}
