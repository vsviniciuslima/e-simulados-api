package br.usp.esimulados.resource;

import br.usp.esimulados.model.exam.Exam;
import br.usp.esimulados.model.exam.dto.CreateExamDTO;
import br.usp.esimulados.service.ExamsService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Slf4j
@Path("/exams")
@ApplicationScoped
@Tag(name = "Exams")
public class ExamsResource {

    @Inject
    ExamsService examsService;

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Criar simulado")
    @APIResponse(description = "Simulado criado",
            responseCode = "200",
            content = { @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            implementation = Exam.class,
                            type = SchemaType.OBJECT
                    ))
            })
    public Response createExam(
           @Valid @RequestBody(description = "Simulado a ser criado") CreateExamDTO createExam
    ) {
        return Response.ok(examsService.createExam(createExam)).build();
    }

}
