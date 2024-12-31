package br.usp.esimulados.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InputValidationException extends RuntimeException {
    public InputValidationException(String message) {
        super(message);
    }
}
