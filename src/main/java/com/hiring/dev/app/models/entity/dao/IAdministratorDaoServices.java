package com.hiring.dev.app.models.entity.dao;

import java.util.List;

import com.hiring.dev.app.models.entity.Administrator;

public interface IAdministratorDaoServices {

	List<Administrator> findAll();
	void save(Administrator admin);
	Administrator findOne(Long id);
	void delete(Long id);
}
