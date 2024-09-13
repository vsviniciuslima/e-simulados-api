package br.usp.esimulados.resource.generated;

import br.usp.esimulados.model.exam.ExamAttempt;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.MethodProperties;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties
public interface ExamAttempts extends PanacheEntityResource<ExamAttempt, Long> {

    @MethodProperties(exposed = false)
    ExamAttempt add(ExamAttempt entity);

}