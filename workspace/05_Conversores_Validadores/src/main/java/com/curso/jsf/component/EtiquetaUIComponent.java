package com.curso.jsf.component;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent(value="etiqueta")
public class EtiquetaUIComponent extends UIComponentBase {

	@Override
	public String getFamily() {
		return null;
	}
	
	@Override
	public void encodeAll(FacesContext context) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		
		responseWriter.startElement("div", null);
		
		responseWriter.startElement("span", null);
		
		responseWriter.append("Hola Mundo!!!");
		
		responseWriter.endElement("span");
		
		responseWriter.endElement("div");
		
	}
	
}
