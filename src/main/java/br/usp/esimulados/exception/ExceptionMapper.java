package br.usp.esimulados.exception;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import java.util.Map;

@Slf4j
@ApplicationScoped
public class ExceptionMapper {

    @ServerExceptionMapper
    public RestResponse<Object> map(EntityNotFoundException entityNotFoundException) {
        Map<String, String> body = Map.of(
                "message", entityNotFoundException.getMessage()
        );
        return RestResponse.status(Response.Status.NOT_FOUND, body);
    }

    @ServerExceptionMapper
    public RestResponse<Object> map(InputValidationException inputValidationException) {
        Map<String, String> body = Map.of(
                "message", inputValidationException.getMessage()
        );
        log.warn(inputValidationException.getMessage());
        return RestResponse.status(Response.Status.BAD_REQUEST, body);
    }
}
