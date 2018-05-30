package com.curso.jsf.model.bussiness;

import com.curso.jsf.model.entities.Persona;

public interface IdealNegocio {

	boolean esIdeal(Persona candidata, Persona laQueBusca);
	
}
