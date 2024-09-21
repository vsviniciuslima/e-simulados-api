package br.usp.esimulados.model.questions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionHistory implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long attemptCount = 0L;
    private Long correctAnswersCount = 0L;

    private UUID uuid = UUID.randomUUID();
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
