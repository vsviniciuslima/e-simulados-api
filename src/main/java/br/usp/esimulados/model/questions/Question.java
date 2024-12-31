package br.usp.esimulados.model.questions;

import br.usp.esimulados.common.entity.ExtendedEntity;
import br.usp.esimulados.model.common.Difficulty;
import br.usp.esimulados.model.common.Discipline;
import br.usp.esimulados.model.common.ExamType;
import br.usp.esimulados.model.common.Topic;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "questions")
public class Question extends PanacheEntity {

    @Column(columnDefinition = "TEXT")
    private String statement;
    private String explanation;
    private Difficulty difficulty;
    private ExamType examType;

    @ManyToOne private Discipline discipline;
    @ManyToOne private Topic topic;

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


    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "alternatives", columnDefinition = "jsonb"/*, insertable = false, updatable = false*/)
    private List<QuestionAlternative> alternatives;
    private char correctAlternative;

}
