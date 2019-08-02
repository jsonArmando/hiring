package com.hiring.dev.app.models.entity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.hiring.dev.app.models.entity.Department;
import com.hiring.dev.app.models.entity.dao.IDepartmentDaoServices;

public class IDepartmentDaoImpl implements IDepartmentDaoServices{
	@PersistenceContext
	private EntityManager em;
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Department> findAllDep() {
		return em.createQuery("FROM DEPARTMENT").getResultList();
	}
	@Override
	public Department findAll() {
		return (Department) em.createQuery("FROM DEPARTMENT").getResultList();
	}

}
