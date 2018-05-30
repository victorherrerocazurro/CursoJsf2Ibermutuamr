package com.curso.jsf.presentation.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.curso.jsf.model.entities.Persona;
import com.curso.jsf.model.service.PersonaServicio;

@ManagedBean
@RequestScoped
public class PersonaBackingBean {

	@ManagedProperty("#{simplePersonaServicio}")
	private PersonaServicio servicio;
	
	private Persona persona;
	
	private String userName;
	
	private String password;
	
	public void setServicio(PersonaServicio servicio) {
		this.servicio = servicio;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String login() {
		Persona persona = servicio.login(userName, password);
		if (persona != null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("persona", persona);
			return "home?faces-redirect=true";
		} else {
			return null;
		}
	}
	
	public Persona getIdeal() {
		Persona laQueBusca = (Persona) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("persona");
		return servicio.buscarIdeal(laQueBusca);
	}
	
	public List<Persona> getAfines() {
		Persona laQueBusca = (Persona) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("persona");
		return servicio.buscarAfines(laQueBusca);
	}
	
	public String registrar() {
		servicio.registrar(persona);
		return "login";
	}
	
}
