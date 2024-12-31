package br.usp.esimulados.service;

import br.usp.esimulados.exception.EntityNotFoundException;
import br.usp.esimulados.model.exam.Exam;
import br.usp.esimulados.model.exam.ExamAttempt;
import br.usp.esimulados.model.exam.dto.AttemptExamDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class ExamAttemptsService {

    @Inject
    EntityMapper entityMapper;

    public ExamAttempt add(AttemptExamDTO attemptExam) {
        Exam exam = (Exam) Exam.findByIdOptional(attemptExam.examId())
                .orElseThrow(() -> new EntityNotFoundException("Exam not found"));

        ExamAttempt examAttempt = entityMapper.attemptExamToExamAttempt(attemptExam);

        exam.getQuestions()
                .forEach(question -> attemptExam.answers()
                .stream()
                .filter(answer -> answer.questionId().equals(question.id))
                .findFirst()
                .ifPresent(answer -> {
                    if(question.getCorrectAlternative() == answer.alternativeId()) {
                        examAttempt.setScore(examAttempt.getScore() + 1);
                    }
                }));
        if(Exam.findById(attemptExam.examId()) == null) {
            throw new EntityNotFoundException("Exam not found");
        }

//        if(User.findById(attemptExam.userId()) == null) {
//            throw new ObjectNotFoundException("User not found");
//        }

        examAttempt.persist();
        return examAttempt;
    }

}
