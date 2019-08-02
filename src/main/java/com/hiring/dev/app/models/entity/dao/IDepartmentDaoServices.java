package com.hiring.dev.app.models.entity.dao;

import java.util.List;

import com.hiring.dev.app.models.entity.Department;

public interface IDepartmentDaoServices {
	public List<Department> findAllDep();
	public Department findAll();
}
