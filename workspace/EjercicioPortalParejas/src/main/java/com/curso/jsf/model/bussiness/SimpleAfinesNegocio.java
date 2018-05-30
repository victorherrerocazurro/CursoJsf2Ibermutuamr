package com.curso.jsf.model.bussiness;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.curso.jsf.model.entities.Persona;

@ManagedBean
@ApplicationScoped
public class SimpleAfinesNegocio implements AfinesNegocio {

	@Override
	public boolean esAfin(Persona candidata, Persona laQueBusca) {
		return !laQueBusca.equals(candidata) && 
				Math.abs(laQueBusca.getEdad() - candidata.getEdad()) <= 10 &&
				Math.abs(laQueBusca.getAltura() - candidata.getAltura()) <= 0.50 ;
	}
	
}
