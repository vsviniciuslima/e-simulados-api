package br.usp.esimulados.model.questions.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateQuestionAlternativeDTO(
    List<String> imageUrls,
    @NotNull String content,
    @NotNull boolean correct
) { }
