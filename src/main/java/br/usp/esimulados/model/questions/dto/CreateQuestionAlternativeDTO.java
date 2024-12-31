package br.usp.esimulados.model.questions.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateQuestionAlternativeDTO(
    String label,
    @NotNull String content,
    List<String> imageUrls
) { }
