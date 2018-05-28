package com.curso.jsf.holamundo.presentation.controller;

import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UltimosSaludosLinkedList implements UltimosSaludos {

	private List<String> saludos = new LinkedList<>();
	
	/* (non-Javadoc)
	 * @see com.curso.jsf.holamundo.presentation.controller.UltimosSaludos#addSaludo(java.lang.String)
	 */
	@Override
	public void addSaludo(String saludo) {
		saludos.add(saludo);
	}

	/* (non-Javadoc)
	 * @see com.curso.jsf.holamundo.presentation.controller.UltimosSaludos#getSaludos()
	 */
	@Override
	public List<String> getSaludos() {
		return saludos;
	}
}
