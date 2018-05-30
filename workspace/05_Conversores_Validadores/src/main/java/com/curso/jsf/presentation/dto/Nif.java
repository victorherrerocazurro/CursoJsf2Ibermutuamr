package com.curso.jsf.presentation.dto;

public class Nif {

	private int numero;
	private char letra;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public char getLetra() {
		return letra;
	}
	public void setLetra(char letra) {
		this.letra = letra;
	}
	public Nif(int numero, char letra) {
		super();
		this.numero = numero;
		this.letra = letra;
	}
	public Nif() {
		super();
	}
	
	@Override
	public String toString() {
		return numero + "-" + letra;
	}

}
