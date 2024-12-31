package br.usp.esimulados.resource.generated;

import br.usp.esimulados.model.common.Discipline;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.MethodProperties;
import io.quarkus.rest.data.panache.ResourceProperties;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Project: e-simulados
 * Package: br.usp.esimulados.resource.generated
 * <p>
 * User: Vinicius Santana
 * Date: 11/6/2024
 * Time: 9:03 PM
 */
@Tag(name = "Disciplines")
@ResourceProperties
public interface Disciplines extends PanacheEntityResource<Discipline, Long> {

    @MethodProperties(exposed = false)
    Discipline add(Discipline entity);

}