package com.curso.jsf.model.service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.curso.jsf.model.bussiness.AfinesNegocio;
import com.curso.jsf.model.bussiness.IdealNegocio;
import com.curso.jsf.model.entities.Persona;
import com.curso.jsf.model.persistence.PersonaDao;

@ManagedBean
@ApplicationScoped
public class SimplePersonaServicio implements PersonaServicio {

	@ManagedProperty("#{personaDao}")
	private PersonaDao dao;
	
	@ManagedProperty("#{simpleAfinesNegocio}")
	private AfinesNegocio afines;
	
	@ManagedProperty("#{simpleIdealNegocio}")
	private IdealNegocio ideal;
	
	public void setDao(PersonaDao dao) {
		this.dao = dao;
	}

	public void setAfines(AfinesNegocio afines) {
		this.afines = afines;
	}
	
	public void setIdeal(IdealNegocio ideal) {
		this.ideal = ideal;
	}

	@Override
	public Persona login(String login, String password) {
		return dao.findByUserAndPassword(login, password);
	}

	@Override
	public Persona registrar(Persona persona) {
		Integer id = dao.add(persona);
		
		Persona resultado = dao.findById(id);
		
		return resultado;
	}

	@Override
	public Persona buscarIdeal(Persona laQueBusca) {

		Collection<Persona> candidatos = dao.find();
		
		for (Persona candidata : candidatos) {
			if (ideal.esIdeal(candidata, laQueBusca)) {
				return candidata;
			}
		}
		
		return null;
	}

	@Override
	public List<Persona> buscarAfines(Persona laQueBusca) {

		List<Persona> afines = new LinkedList<>();
		
		Collection<Persona> candidatos = dao.find();
		
		for (Persona candidata : candidatos) {
			if (this.afines.esAfin(candidata, laQueBusca)) {
				afines.add(candidata);
			}
		}
		
		return afines;
	}

}
