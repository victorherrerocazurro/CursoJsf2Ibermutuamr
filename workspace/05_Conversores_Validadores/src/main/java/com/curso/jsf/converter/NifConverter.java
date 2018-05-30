package com.curso.jsf.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.curso.jsf.presentation.dto.Nif;

@FacesConverter(value="nifConverter")
public class NifConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2 == null || arg2.equals("")) {
			return null;
		}
		Pattern patron = Pattern.compile("\\d{8}-[A-z]");
		Matcher matcher = patron.matcher(arg2);
		if (!matcher.matches()) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "NIF Conversion error.",
					"Formato no valido para el NIF.");
			throw new ConverterException(msg);
		}
		return new Nif(Integer.parseInt(arg2.substring(0, 8)), arg2.charAt(9));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return value.toString();
	}

}
