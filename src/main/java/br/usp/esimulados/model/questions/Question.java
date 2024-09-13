package br.usp.esimulados.model.questions;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "questions")
public class Question extends PanacheEntity {

    private String statement; // enunciado
    private String explanation;

    private String topic;
    private String subTopic;
    private int year;
    private String source;
    private String sourceUrl;
    private String authorId;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "tags", columnDefinition = "jsonb"/*, insertable = false, updatable = false*/)
    private List<String> tags;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "comments", columnDefinition = "jsonb"/*, insertable = false, updatable = false*/)
    private List<Comment> comments;

    private QuestionDifficulty difficulty; // EASY, MEDIUM, HARD

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "alternatives", columnDefinition = "jsonb"/*, insertable = false, updatable = false*/)
    private List<QuestionAlternative> alternatives;

    private UUID uuid = UUID.randomUUID();
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
