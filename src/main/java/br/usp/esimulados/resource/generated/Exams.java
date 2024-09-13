package br.usp.esimulados.resource.generated;

import br.usp.esimulados.model.exam.Exam;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.MethodProperties;
import io.quarkus.rest.data.panache.ResourceProperties;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Tag(name = "Exams")
@ResourceProperties
public interface Exams extends PanacheEntityResource<Exam, Long> {

    @MethodProperties(exposed = false)
    Exam add(Exam entity);

}