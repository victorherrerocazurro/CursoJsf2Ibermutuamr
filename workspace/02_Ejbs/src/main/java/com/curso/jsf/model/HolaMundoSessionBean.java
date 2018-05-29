package com.curso.jsf.model;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 * Session Bean implementation class HolaMundoSessionBean
 */
//@Stateless
//@LocalBean
@Named
public class HolaMundoSessionBean {

    /**
     * Default constructor. 
     */
    public HolaMundoSessionBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String generarSaludo(String nombre) {
    	return "Hola " + nombre + "!";
    }
    

}
