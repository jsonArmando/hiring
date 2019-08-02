package com.hiring.dev.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CONSECUTIVO")
	private Long id;
	@Column(name="COD_DEP")
	private Long codDep;
	@Column(name="NOM_DEP")
	private String nomDep;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCodDep() {
		return codDep;
	}
	public void setCodDep(Long codDep) {
		this.codDep = codDep;
	}
	public String getNomDep() {
		return nomDep;
	}
	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}
}
