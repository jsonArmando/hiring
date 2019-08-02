package com.hiring.dev.app.models.entity.dao.service;

import java.util.List;

import com.hiring.dev.app.models.entity.Administrator;

public interface IAdministratorService {
	List<Administrator> findAll();
	void save(Administrator admin);
	Administrator findOne(Long id);
	void delete(Long id);
}
