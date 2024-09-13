package br.usp.esimulados.model.questions.dto;

public record CreateCommentDTO(
    String content,
    String author,
    String authorId
) { }
