package com.hiring.dev.app.models.entity.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.dev.app.models.entity.Administrator;
import com.hiring.dev.app.models.entity.dao.IAdministratorDaoServices;

@Service
public class IAdministratorServiceImpl implements IAdministratorService{
	
	@Autowired
	private IAdministratorDaoServices administratorDao;
	@Override
	@Transactional(readOnly = true)
	public List<Administrator> findAll() {
		return administratorDao.findAll();
	}

	@Override	
	@Transactional
	public void save(Administrator admin) {
		administratorDao.save(admin);
	}

	@Override
	@Transactional(readOnly = true)
	public Administrator findOne(Long id) {
		return administratorDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		administratorDao.delete(id);	
	}

}
