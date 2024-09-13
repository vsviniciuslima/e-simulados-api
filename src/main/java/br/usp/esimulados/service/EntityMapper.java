package br.usp.esimulados.service;

import br.usp.esimulados.model.exam.Exam;
import br.usp.esimulados.model.exam.ExamAttempt;
import br.usp.esimulados.model.exam.dto.AttemptExamDTO;
import br.usp.esimulados.model.exam.dto.CreateExamDTO;
import br.usp.esimulados.model.questions.Comment;
import br.usp.esimulados.model.questions.Question;
import br.usp.esimulados.model.questions.dto.CreateCommentDTO;
import br.usp.esimulados.model.questions.dto.CreateQuestionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface EntityMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "questions", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Exam createExamToExam(CreateExamDTO createExam);

    @Mapping(target = "comments", ignore = true)
    Question createQuestionToQuestion(CreateQuestionDTO createQuestion);

    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Comment createCommentToComment(CreateCommentDTO createComment);

    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    ExamAttempt attemptExamToExamAttempt(AttemptExamDTO attemptExam);
}
