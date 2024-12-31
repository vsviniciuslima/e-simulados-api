package br.usp.esimulados.model.exam.dto;

public record Answer(
    Long questionId,
    Character alternativeId
) { }
