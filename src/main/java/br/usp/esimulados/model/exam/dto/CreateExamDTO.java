package br.usp.esimulados.model.exam.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateExamDTO(
    @NotEmpty(message = "É necessário adicionar ao menos uma questão ao simulado.")
    List<String> questionIds,
    List<String> tags,
    @NotNull String category,
    @NotNull String subCategory,
    @NotNull String author,
    @NotNull String authorId,
    @NotNull String name,
    @NotNull String description,
    @NotNull String imageUrl
) { }
