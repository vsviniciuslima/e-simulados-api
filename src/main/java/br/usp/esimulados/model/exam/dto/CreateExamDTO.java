package br.usp.esimulados.model.exam.dto;

import br.usp.esimulados.model.common.Difficulty;
import br.usp.esimulados.model.common.ExamType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateExamDTO(
    @NotEmpty(message = "É necessário adicionar ao menos uma questão ao simulado.")
    List<String> questionIds,
    String author,
    String authorId,
    @NotNull ExamType examType,
    Difficulty difficulty,
    @NotNull String name,
    String description,
    String imageUrl,
    int year,
    List<String> tags,
    @NotNull long disciplineId,
    @NotNull long topicId
) { }
