package com.zhou.dao;

import java.util.List;

import com.zhou.model.Department;


public interface DepartmentDao {
	/**
     * @param 
     * @return Department
     */
    public void saveDep(Department department);
    public List<Department> findAllDep();
    public void updateDep(Department department);
	public void deleteDep(int dId);
}
