package br.usp.esimulados.model.questions.dto;

import br.usp.esimulados.model.questions.QuestionDifficulty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateQuestionDTO(
    @NotNull String statement,
    String explanation,
    @NotNull String topic,
    @NotNull String subTopic,
    int year,
    String source,
    String sourceUrl,
    @NotNull String authorId,
    @NotNull List<String> tags,
    @NotNull QuestionDifficulty questionDifficulty,
    @NotNull List<CreateQuestionAlternativeDTO> questionAlternatives
) { }
