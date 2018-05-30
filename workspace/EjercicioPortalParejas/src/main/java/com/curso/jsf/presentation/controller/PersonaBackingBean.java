package com.curso.jsf.presentation.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import com.curso.jsf.model.entities.Persona;
import com.curso.jsf.model.service.PersonaServicio;

@ManagedBean
@RequestScoped
public class PersonaBackingBean {

	private ExternalContext ec;

	@ManagedProperty("#{simplePersonaServicio}")
	private PersonaServicio servicio;
	
	private Persona persona = new Persona();
	
	private String userName;
	
	private String password;
	
	@PostConstruct
	public void init() {
		ec = FacesContext.getCurrentInstance().getExternalContext();
	}
	
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
			ec.getSessionMap().put("persona", persona);
			return "home?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage("formLogin:login", new FacesMessage(FacesMessage.SEVERITY_INFO,"El usuario o password incado es incorrecto", "Login Incorrecto"));
			return null;
		}
	}
	
	public String logout() {
		 HttpSession session = (HttpSession)ec.getSession(false);
		 session.invalidate();
		return "login?faces-redirect=true";
	}
	
	public void checkLogin() throws IOException {
		if (ec.getSessionMap().get("persona") == null) {
			ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
		}
	}
	
	public Persona getIdeal() {
		Persona laQueBusca = (Persona) ec.getSessionMap().get("persona");
		return servicio.buscarIdeal(laQueBusca);
	}
	
	public List<Persona> getAfines() {
		Persona laQueBusca = (Persona) ec.getSessionMap().get("persona");
		return servicio.buscarAfines(laQueBusca);
	}
	
	public String registrar() {
		servicio.registrar(persona);
		FacesContext.getCurrentInstance().addMessage("formLogin:login", new FacesMessage(FacesMessage.SEVERITY_INFO,"Su id es " + persona.getId(), "Registro Correcto"));
		return "login";
	}
	
}
