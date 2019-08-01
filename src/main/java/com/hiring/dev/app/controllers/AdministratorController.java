package com.hiring.dev.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hiring.dev.app.models.entity.dao.IAdministratorDaoServices;

@Controller
public class AdministratorController {
	@Autowired
	@Qualifier("ADMINISTRATOR")
	private IAdministratorDaoServices administrator;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("title", "Application Administrator");
		model.addAttribute("administrator", administrator.findAll());
		return "list";
	}
}
