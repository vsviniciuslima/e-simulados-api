package br.usp.esimulados.service;

import br.usp.esimulados.model.common.CreateDiscipline;
import br.usp.esimulados.model.common.CreateTopic;
import br.usp.esimulados.model.common.Discipline;
import br.usp.esimulados.model.common.Topic;
import br.usp.esimulados.model.exam.Exam;
import br.usp.esimulados.model.exam.ExamAttempt;
import br.usp.esimulados.model.exam.dto.AttemptExamDTO;
import br.usp.esimulados.model.exam.dto.CreateExamDTO;
import br.usp.esimulados.model.questions.Comment;
import br.usp.esimulados.model.questions.Question;
import br.usp.esimulados.model.questions.QuestionAlternative;
import br.usp.esimulados.model.questions.dto.CreateCommentDTO;
import br.usp.esimulados.model.questions.dto.CreateQuestionAlternativeDTO;
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
    @Mapping(source = "difficulty", target = "difficulty")
    Exam createExamToExam(CreateExamDTO createExam);

    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "discipline", ignore = true)
    Question createQuestionToQuestion(CreateQuestionDTO createQuestion);

    QuestionAlternative createQuestionAlternativeToQuestionAlternative(CreateQuestionAlternativeDTO createQuestionAlternative);

    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Comment createCommentToComment(CreateCommentDTO createComment);

    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    ExamAttempt attemptExamToExamAttempt(AttemptExamDTO attemptExam);

    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    Discipline createDisciplineToDiscipline(CreateDiscipline createDiscipline);

    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    Topic createTopicToTopic(CreateTopic createTopic);
}
