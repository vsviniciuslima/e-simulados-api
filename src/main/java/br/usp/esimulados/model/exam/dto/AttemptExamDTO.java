package br.usp.esimulados.model.exam.dto;

import br.usp.esimulados.model.exam.Answer;

import java.util.List;

public record AttemptExamDTO(
    Long examId,
    Long userId,
    int examVersion,
    int totalQuestions,
    int totalCorrectAnswers,
    List<Answer> answers
) { }
