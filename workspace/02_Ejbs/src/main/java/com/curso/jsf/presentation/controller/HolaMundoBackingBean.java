package com.curso.jsf.presentation.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.curso.jsf.model.HolaMundoSessionBean;

//@ManagedBean
@Named
@RequestScoped
public class HolaMundoBackingBean {

	//@EJB
	@Inject
	private HolaMundoSessionBean holaMundoSessionBean;

	// Definir una campo que permita al Bean recoger el texto del formulario
	private String nombre;

	// getter y setter
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Definir un campo que permita al Bean devolver al cliente el saludo
	private String saludo;

	public String getSaludo() {
		return saludo;
	}

	// Definir un metodo que permita al Bean procesar la peticion del Cliente
	public void saludar() {
		this.saludo = holaMundoSessionBean.generarSaludo(this.nombre);
	}

}
