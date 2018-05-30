package com.curso.jsf.model.persistence;

import java.util.Collection;
import com.curso.jsf.model.entities.Persona;

public interface PersonaDao {

	Integer add(Persona persona);

	Collection<Persona> find();
	
	Persona findById(int id);
	
	Persona findByUserAndPassword(String login, String password);

}
