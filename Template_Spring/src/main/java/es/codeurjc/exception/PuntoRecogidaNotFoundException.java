package es.codeurjc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PuntoRecogidaNotFoundException extends RuntimeException {

    public PuntoRecogidaNotFoundException(int id) {
        super("No se encontró el punto de recogida con ID: " + id);
    }
}
