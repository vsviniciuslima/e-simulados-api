package br.usp.esimulados.resource;

import br.usp.esimulados.model.common.CreateTopic;
import br.usp.esimulados.model.common.Discipline;
import br.usp.esimulados.model.common.Topic;
import br.usp.esimulados.service.EntityMapper;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
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
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Slf4j
@ApplicationScoped
@Path("/topics")
@Tag(name = "Topics")
public class TopicsResource {

    @Inject
    EntityMapper entityMapper;

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(
           @Valid @RequestBody(description = "Tópico a ser criado") CreateTopic createTopic
    ) {
        Discipline discipline = (Discipline) Discipline
                .findByIdOptional(createTopic.disciplineId())
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada"));

        Topic topic = entityMapper.createTopicToTopic(createTopic);
        topic.setDiscipline(discipline);
        topic.persist();

        return Response.ok(topic).build();
    }

}
