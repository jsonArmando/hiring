package com.hiring.dev.app.models.entity.dao;

import java.util.List;

import com.hiring.dev.app.models.entity.Administrator;

public interface IAdministratorDaoServices {

	public List<Administrator> findAll();
	public void save(Administrator admin);
}
