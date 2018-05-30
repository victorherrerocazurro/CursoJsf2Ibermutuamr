package com.curso.jsf.model.bussiness;

import com.curso.jsf.model.entities.Persona;

public interface AfinesNegocio {

	boolean esAfin(Persona candidata, Persona laQueBusca);
	
}
