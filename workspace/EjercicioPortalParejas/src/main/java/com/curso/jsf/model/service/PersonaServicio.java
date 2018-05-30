package com.curso.jsf.model.service;

import java.util.List;

import com.curso.jsf.model.entities.Persona;

public interface PersonaServicio {

	Persona login(String login, String password);
	
	Persona registrar(Persona persona);
	
	Persona buscarIdeal(Persona laQueBusca);
	
	List<Persona> buscarAfines(Persona laQueBusca);
}
