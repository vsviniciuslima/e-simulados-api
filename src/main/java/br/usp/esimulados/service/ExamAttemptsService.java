package br.usp.esimulados.service;

import br.usp.esimulados.exception.ObjectNotFoundException;
import br.usp.esimulados.model.exam.Exam;
import br.usp.esimulados.model.exam.ExamAttempt;
import br.usp.esimulados.model.exam.dto.AttemptExamDTO;
import br.usp.esimulados.model.user.User;
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
        if(Exam.findById(attemptExam.examId()) == null) {
            throw new ObjectNotFoundException("Exam not found");
        }

        if(User.findById(attemptExam.userId()) == null) {
            throw new ObjectNotFoundException("User not found");
        }

        ExamAttempt examAttempt = entityMapper.attemptExamToExamAttempt(attemptExam);
        examAttempt.persist();
        return examAttempt;
    }

}
