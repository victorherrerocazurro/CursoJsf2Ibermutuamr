package com.curso.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
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
	
	
	
}
