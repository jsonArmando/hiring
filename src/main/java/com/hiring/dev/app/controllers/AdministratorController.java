package com.hiring.dev.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hiring.dev.app.models.entity.Administrator;
import com.hiring.dev.app.models.entity.Department;
import com.hiring.dev.app.models.entity.dao.IAdministratorDaoServices;
import com.hiring.dev.app.models.entity.dao.IDepartmentDaoServices;
import com.hiring.dev.app.models.entity.dao.service.IAdministratorService;

@Controller
public class AdministratorController {
	@Autowired
	//@Qualifier("ADMINISTRATOR")
	private IAdministratorService administrator;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("title", "Application Administrator");
		model.addAttribute("administrator", administrator.findAll());
		return "list";
	}
	@RequestMapping(value="/form")
	public String create(Map<String, Object> model) {
		Administrator admin = new Administrator();
		model.put("administrator", admin);
		model.put("title", "Administrator Form");
		return "form";
	}
	@RequestMapping(value="/form/{id}")
	public String edit(@PathVariable(value="id") Long id, Map<String, Object> model) {
		Administrator admin = null;
		if(id>0) {
			admin=administrator.findOne(id);
		}else {
			return "redirect:/list";
		}
		model.put("administrator", admin);
		model.put("title", "Administrator Form");
		return "form";
	}
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String save(@Valid Administrator saveAdmin,BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title", "Application Administrator");
			return "form";
		}
		administrator.save(saveAdmin);
		return "redirect:list";
	}
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Long id) {
		if(id>0) {
			administrator.delete(id);
		}
		return "redirect:/list";
	}
}
