package br.usp.esimulados.model.exam;

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
@Entity(name = "exam_attempts")
public class ExamAttempt extends PanacheEntity {
    private Long examId;
    private Long userId;
    private int examVersion;
    private int totalQuestions;
    private int totalCorrectAnswers;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "answers", columnDefinition = "jsonb"/*, insertable = false, updatable = false*/)
    private List<Answer> answers;

    private boolean active;
    private UUID uuid = UUID.randomUUID();
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
