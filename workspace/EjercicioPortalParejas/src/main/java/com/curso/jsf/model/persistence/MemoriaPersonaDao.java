package com.curso.jsf.model.persistence;

import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.curso.jsf.model.entities.Persona;

@ManagedBean(name="personaDao")
@ApplicationScoped
public class MemoriaPersonaDao implements PersonaDao {

	@ManagedProperty("#{tablaPersonas}")
	private Map<Integer, Persona> personas; 
	
	private int contador = 1;
	
	public void setPersonas(Map<Integer, Persona> personas) {
		this.personas = personas;
	}

	//No se puede hacer porque en el momento de la construccion no se tiene disponiblidad de personas
	/*public MemoriaPersonaDao() {
		personas.put(1, new Persona(1, "victor", "victor", "Victor", "Herrero", 40, 1.8));
		personas.put(2, new Persona(2, "jaime", "jaime", "Jaime", "Fernandez", 39, 1.85));
		personas.put(3, new Persona(3, "victoria", "victoria", "Victoria", "Martinez", 39, 1.75));
	}*/
	
	@PostConstruct
	public void init() {
		add(new Persona(1, "victor", "victor", "Victor", "Herrero", 40, 1.8));
		add(new Persona(2, "jaime", "jaime", "Jaime", "Fernandez", 34, 1.85));
		add(new Persona(3, "victoria", "victoria", "Victoria", "Martinez", 39, 1.75));
	}

	@Override
	public Integer add(Persona persona) {
		persona.setId(contador++);
		personas.put(persona.getId(), persona);
		return persona.getId();
	}

	@Override
	public Collection<Persona> find() {
		return personas.values();
	}

	@Override
	public Persona findById(int id) {
		return personas.get(id);

	}

	@Override
	public Persona findByUserAndPassword(String login, String password) {
		
		for (Persona persona : personas.values()) {
			if(persona.getLogin().equals(login) && persona.getPassword().equals(password)) {
				return persona;
			}
		}
		return null;
	}

}
