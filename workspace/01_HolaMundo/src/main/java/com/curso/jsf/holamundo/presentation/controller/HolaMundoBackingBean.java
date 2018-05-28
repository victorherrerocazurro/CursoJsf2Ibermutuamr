package com.curso.jsf.holamundo.presentation.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class HolaMundoBackingBean {

	//Inyecion de dependencias
	@ManagedProperty(value="#{ultimosSaludosLinkedList}")
	private UltimosSaludos saludos;
	
	public void setSaludos(UltimosSaludos saludos) {
		this.saludos = saludos;
	}

	//Definir una campo que permita al Bean recoger el texto del formulario
	private String nombre;
	//getter y setter
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//Definir un campo que permita al Bean devolver al cliente el saludo
	private String saludo;
	
	public String getSaludo() {
		return saludo;
	}
	
	private String error;
	
	public String getError() {
		return error;
	}
	//Definir un metodo que permita al Bean procesar la peticion del Cliente
	public void saludar() {
		this.saludo = "Hola " + this.nombre + "!";
	}
	
	public String saludarConNavegacion() {
		
		if(nombre.equals("Victor")) {
			
			this.error = "Ha habido un fallo!";
			
			return "failure";
		} else {
			
			this.saludo = "Hola " + this.nombre + "!";
		
			this.saludos.addSaludo(saludo);
			
			return "success";
		}
	}
}
