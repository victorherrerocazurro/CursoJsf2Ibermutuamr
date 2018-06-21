package com.curso.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.event.ActionEvent;

@ManagedBean(name="backingBean")
@RequestScoped
public class ListadoBackingBean {

	@ManagedProperty(value="#{lista}")
	private List<Persona> lista;
	
	public void setLista(List<Persona> lista) {
		this.lista = lista;
	}

	@PostConstruct
	public void init() {
		lista.add(new Persona("Victor", "Herrero"));
		lista.add(new Persona("Juan", "Martinez"));
		lista.add(new Persona("Laura", "Herrero"));
		lista.add(new Persona("Maria", "Hernandez"));
	}

	public List<Persona> getLista() {
		return lista;
	}
	
	public String metodo(String accion) {
		return null;
	}
	
	public String accion(String accion) {
		return null;
	}
	
	public void establecerOrigen(ActionEvent event) {
		
	}
	
	private boolean mostrar = false;

	private HtmlOutputText outputText;

	public boolean isMostrar() {
		return mostrar;
	}

	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}

	public HtmlOutputText getOutputText() {
		return outputText;
	}

	public void setOutputText(HtmlOutputText outputText) {
		this.outputText = outputText;
	}
	
}
