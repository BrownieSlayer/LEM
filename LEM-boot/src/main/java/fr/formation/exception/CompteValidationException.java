package fr.formation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Le compte n'a pas pu etre valide")
public class CompteValidationException extends RuntimeException{

	private static final long serialVersionUID = 8005633159687641834L;

}
