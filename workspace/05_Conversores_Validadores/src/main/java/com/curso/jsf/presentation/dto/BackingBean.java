package com.curso.jsf.presentation.dto;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class BackingBean {

	private Nif nif;
	private int cantidad;
	private String mail;

	public Nif getNif() {
		return nif;
	}

	public void setNif(Nif nif) {
		this.nif = nif;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void procesar() {
		System.out.println("No llegamos");
	}
	
}
