package br.usp.esimulados.service;

import br.usp.esimulados.model.exam.Exam;
import br.usp.esimulados.model.exam.dto.CreateExamDTO;
import br.usp.esimulados.model.questions.Question;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class ExamsService {

    @Inject
    EntityMapper entityMapper;

    public Exam createExam(CreateExamDTO createExam) {
        Exam exam = entityMapper.createExamToExam(createExam);

        List<Question> questions = Question.list("id in ?1", createExam.questionIds());
        exam.setQuestions(questions);

        log.info("Creating exam: {}", exam);
        exam.persist();

        return exam;
    }

}
