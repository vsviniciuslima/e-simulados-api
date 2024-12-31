package br.usp.esimulados.resource.generated;

import br.usp.esimulados.model.common.Topic;
import br.usp.esimulados.model.exam.ExamAttempt;
import br.usp.esimulados.model.questions.Question;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.MethodProperties;
import io.quarkus.rest.data.panache.ResourceProperties;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * <b>Project</b>: e-simulados <br>
 * <b>Package</b>: br.usp.esimulados.resource.generated <br>
 * <b>User</b>: Vinicius Santana <br>
 * <b>Date</b>: 11/6/2024
 * <b>Time</b>: 9:41 PM <br>
 */

@Tag(name = "Topics")
@ResourceProperties
public interface Topics extends PanacheEntityResource<Topic, Long> {
    @MethodProperties(exposed = false)
    Topic add(Topic entity);
}