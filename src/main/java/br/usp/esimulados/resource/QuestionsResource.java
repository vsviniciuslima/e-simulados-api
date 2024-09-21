package br.usp.esimulados.resource;

import br.usp.esimulados.model.questions.Question;
import br.usp.esimulados.model.questions.dto.CreateCommentDTO;
import br.usp.esimulados.model.questions.dto.CreateQuestionDTO;
import br.usp.esimulados.service.QuestionsService;
import io.vertx.core.http.HttpServerRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
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

import java.util.UUID;

@Slf4j
@Tag(name = "Questions")
@Path("/questions")
@ApplicationScoped
public class QuestionsResource {

    @Inject
    QuestionsService questionsService;

    @Inject
    HttpServerRequest request;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Criar questão")
    @APIResponse(description = "Questão criada",
            responseCode = "200",
            content = { @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            implementation = Question.class,
                            type = SchemaType.OBJECT
                    ))
            })
    public Response createQuestion(
           @Valid @RequestBody(description = "Questão a ser criada") CreateQuestionDTO createQuestion
    ) {
        log.info("Request: {}", request.toString());
        return Response.ok(questionsService.createQuestion(createQuestion)).build();
    }

    @POST
    @Transactional
    @Path("/{id}/comments")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addComment(
            @PathParam("id") Long questionId,
            @RequestBody(description = "Comentário") CreateCommentDTO comment
    ) {
        this.questionsService.addComment(questionId, comment);
        return Response.ok().build();
    }

    @DELETE
    @Transactional
    @Path("/{id}/comments/{commentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addComment(
            @PathParam("id") Long questionId,
            @PathParam("commentId") UUID commentId
    ) {
        this.questionsService.deleteComment(questionId, commentId);
        return Response.ok().build();
    }

}
