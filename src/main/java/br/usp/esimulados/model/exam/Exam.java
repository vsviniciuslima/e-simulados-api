package br.usp.esimulados.model.exam;

import br.usp.esimulados.model.questions.Question;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "exams")
@RegisterForReflection
public class Exam extends PanacheEntity {

    @OneToMany
    private List<Question> questions;
    private String author;
    private String authorId;

    // Cabeçalho
    private String name;
    private String description;
    private String imageUrl;

    // filtros
    @ElementCollection
    private List<String> tags;
    private String category;
    private String subCategory;

    // Controle interno
    private UUID uuid = UUID.randomUUID();
    private int version = 0;
    private boolean active = true;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

}
