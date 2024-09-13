package br.usp.esimulados.exception;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import java.util.Map;

@ApplicationScoped
public class ExceptionMapper {

    @ServerExceptionMapper
    public RestResponse<Object> mapException(ObjectNotFoundException objectNotFoundException) {
        Map<String, String> body = Map.of(
                "message", objectNotFoundException.getMessage()
        );
        return RestResponse.status(Response.Status.NOT_FOUND, body);
    }
}
