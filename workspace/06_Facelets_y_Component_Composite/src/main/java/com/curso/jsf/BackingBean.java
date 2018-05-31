package com.curso.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BackingBean {

	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String buscar() {
		
		System.out.println("Ejecutar la logica de busqueda con el valor: " + texto);
		
		return null;
	}
	
}
