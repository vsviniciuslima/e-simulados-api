package br.usp.esimulados.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
