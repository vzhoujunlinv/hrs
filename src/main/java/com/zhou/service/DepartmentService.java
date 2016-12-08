package com.zhou.service;

import java.util.List;

import com.zhou.model.Department;

public interface DepartmentService {
	public void saveDep(Department department);
    public List<Department> findAllDep();
    public void updateDep(Department department);
}

