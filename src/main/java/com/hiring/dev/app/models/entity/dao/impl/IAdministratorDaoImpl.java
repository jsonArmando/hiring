package com.hiring.dev.app.models.entity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.dev.app.models.entity.Administrator;
import com.hiring.dev.app.models.entity.dao.IAdministratorDaoServices;

@Repository("ADMINISTRATOR")
public class IAdministratorDaoImpl implements IAdministratorDaoServices {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Administrator> findAll() {
		return em.createQuery("FROM Administrator").getResultList();
	}

	@Override
	public void save(Administrator admin) {
		if(admin.getConsecutivo() !=null && admin.getConsecutivo()>0) {
			em.merge(admin);
		}else {
		em.persist(admin);
		}
	}

	@Override
	public Administrator findOne(Long id) {
		return em.find(Administrator.class, id);
	}

	@Override
	public void delete(Long id) {
		em.remove(findOne(id));
	}

}
