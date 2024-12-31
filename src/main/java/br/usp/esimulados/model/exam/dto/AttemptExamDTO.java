package br.usp.esimulados.model.exam.dto;

import java.util.List;

public record AttemptExamDTO(
    Long examId,
    Long userId,
    List<Answer> answers
) { }
