package br.usp.esimulados.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
