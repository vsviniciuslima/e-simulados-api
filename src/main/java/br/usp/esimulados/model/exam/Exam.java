package br.usp.esimulados.model.exam;

import br.usp.esimulados.model.common.Difficulty;
import br.usp.esimulados.model.common.Discipline;
import br.usp.esimulados.model.common.ExamType;
import br.usp.esimulados.model.common.Topic;
import br.usp.esimulados.model.questions.Question;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @ManyToMany
    private List<Question> questions;

    private String author;
    private String authorId;

    // Cabeçalho
    private ExamType examType;
    private Difficulty difficulty;
    private String name;
    private String description;
    private String imageUrl;
    private int year;

    // filtros
    @ElementCollection
    private List<String> tags;

    @ManyToOne
//    @JoinColumn(name = "category_id")
    private Discipline discipline;

    @ManyToOne
    private Topic topic;

    // Controle interno
    private int version = 0;
    private boolean active = true;
    private UUID uuid = UUID.randomUUID();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
