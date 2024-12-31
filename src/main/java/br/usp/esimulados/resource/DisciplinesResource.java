package br.usp.esimulados.resource;

import br.usp.esimulados.model.common.CreateDiscipline;
import br.usp.esimulados.model.common.Discipline;
import br.usp.esimulados.model.exam.Exam;
import br.usp.esimulados.model.exam.dto.AttemptExamDTO;
import br.usp.esimulados.service.EntityMapper;
import br.usp.esimulados.service.ExamAttemptsService;
import io.vertx.core.http.HttpServerRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
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
@Tag(name = "Disciplines")
@ApplicationScoped
@Path("/disciplines")
public class DisciplinesResource {

    @Inject
    EntityMapper entityMapper;

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Criar disciplina")
    @APIResponse(description = "Disciplina criada",
            responseCode = "200",
            content = { @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            implementation = Discipline.class,
                            type = SchemaType.OBJECT
                    ))
            })
    public Response add(
           @Valid @RequestBody(description = "Simulado a ser criado") CreateDiscipline createDiscipline
    ) {
        Discipline discipline = entityMapper.createDisciplineToDiscipline(createDiscipline);
        discipline.persist();

        return Response.ok(discipline).build();
    }

}
