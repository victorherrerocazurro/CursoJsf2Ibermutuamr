package com.curso.jsf.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="emailValidator")
public class EmailValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		Pattern patron = Pattern.compile("\\d{8}-[A-z]");
		Matcher matcher = patron.matcher((String)value);
		if (!matcher.matches()) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email Validation error.",
					"Formato no valido para el Email.");
			throw new ValidatorException(msg);
		}
	}

}
