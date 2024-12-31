package br.usp.esimulados.model.questions.dto;

import br.usp.esimulados.model.common.Discipline;
import br.usp.esimulados.model.common.Difficulty;
import br.usp.esimulados.model.common.ExamType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateQuestionDTO(
        @NotNull String statement,
        String explanation,
        @NotNull Difficulty difficulty,
        @NotNull ExamType examType,
        @NotNull long disciplineId,
        @NotNull long topicId,
        int year,
        String source,
        String sourceUrl,
        String authorId,
        List<String> tags,
        @NotNull List<CreateQuestionAlternativeDTO> questionAlternatives,
        @NotNull char correctAlternative
) { }
