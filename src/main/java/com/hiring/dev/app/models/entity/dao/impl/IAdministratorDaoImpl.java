package com.hiring.dev.app.models.entity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.dev.app.models.entity.Administrator;
import com.hiring.dev.app.models.entity.dao.IAdministratorDaoServices;

@Repository("ADMINISTRATOR")
public class IAdministratorDaoImpl implements IAdministratorDaoServices{
	@PersistenceContext
	private EntityManager em;
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Administrator> findAll() {
		return em.createQuery("FROM Administrator").getResultList();
	}

}
