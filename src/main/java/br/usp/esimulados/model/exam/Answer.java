package br.usp.esimulados.model.exam;

public record Answer(
    Long questionId,
    Character alternativeId,
    boolean correct,
    String alternativeContent,
    String correctAnswerContent
) { }
