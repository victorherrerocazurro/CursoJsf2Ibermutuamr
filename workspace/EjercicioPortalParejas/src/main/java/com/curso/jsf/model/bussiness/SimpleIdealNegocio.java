package com.curso.jsf.model.bussiness;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.curso.jsf.model.entities.Persona;

@ManagedBean
@ApplicationScoped
public class SimpleIdealNegocio implements IdealNegocio {

	@Override
	public boolean esIdeal(Persona candidata, Persona laQueBusca) {
		return !laQueBusca.equals(candidata) &&
				Math.abs(laQueBusca.getEdad() - candidata.getEdad()) <= 5 &&
				Math.abs(laQueBusca.getAltura() - candidata.getAltura()) <= 0.10 ;
	}
	
}
