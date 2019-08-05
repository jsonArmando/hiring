package com.hiring.dev.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hiring.dev.app.models.entity.Administrator;
import com.hiring.dev.app.models.entity.dao.service.IAdministratorService;

@Controller
public class AdministratorController {
	@Autowired
	private IAdministratorService administrator;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("title", "Application Administrator");
		model.addAttribute("administrator", administrator.findAll());
		return "list";
	}

	@RequestMapping(value = "/form")
	public String create(Map<String, Object> model, RedirectAttributes flash) {
		Administrator admin = new Administrator();
		model.put("administrator", admin);
		model.put("title", "Administrator Form");
		return "form";
	}

	@RequestMapping(value = "/form/{id}")
	public String edit(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Administrator admin = null;
		if (id > 0) {
			admin = administrator.findOne(id);
		} else {
			return "redirect:/list";
		}
		model.put("administrator", admin);
		model.put("title", "Administrator Form");
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String save(@Valid Administrator saveAdmin, BindingResult result, Model model,
			@RequestParam("file") MultipartFile img, RedirectAttributes flash) {
		if (result.hasErrors()) {
			model.addAttribute("title", "Application Administrator");
			return "form";
		}
		if (!img.isEmpty()) {
			Path directoryRecurs = Paths.get("src//main//resources//static/upload");
			String rootPath = directoryRecurs.toFile().getAbsolutePath();
			try {
				byte[] bytes = img.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + img.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				flash.addFlashAttribute("info", "Has subido correctamente '" + img.getOriginalFilename() + "'");
				saveAdmin.setFoto(img.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		administrator.save(saveAdmin);
		return "redirect:list";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id) {
		if (id > 0) {
			administrator.delete(id);
		}
		return "redirect:/list";
	}
	@GetMapping(value="/ver/{id}")	
	public String watch(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Administrator admin = administrator.findOne(id);
		if(admin==null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de Datos");
			return "redirect:/list";
		}
		model.put("administrator", admin);
		model.put("title", "Detalle del Administrator"+ admin.getPrimerNombre());
		return "ver";
	}
}
