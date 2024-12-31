package br.usp.esimulados.service;

import br.usp.esimulados.exception.InputValidationException;
import br.usp.esimulados.model.common.Discipline;
import br.usp.esimulados.model.common.Topic;
import br.usp.esimulados.model.exam.Exam;
import br.usp.esimulados.model.exam.dto.AddExamQuestion;
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

        Discipline discipline = (Discipline) Discipline
                .findByIdOptional(createExam.disciplineId())
                .orElseThrow(() -> new InputValidationException("Disciplina não encontrada"));
        exam.setDiscipline(discipline);

        Topic topic = (Topic) Topic
                .findByIdOptional(createExam.topicId())
                .orElseThrow(() -> new InputValidationException("Tópico não encontrada"));
        exam.setTopic(topic);

        List<Question> questions = Question.list("id in ?1", createExam.questionIds());
        exam.setQuestions(questions);

        log.info("Creating exam: {}", exam);
        exam.persist();

        return exam;
    }

    public void addQuestion(AddExamQuestion addExamQuestion, Long examId) {
        log.info("Adding questions {} to exam {}", addExamQuestion.questionsIds(),  examId);

        Exam exam = (Exam) Exam
                .findByIdOptional(examId)
                .orElseThrow(() -> new InputValidationException("Prova não encontrada"));

        addExamQuestion.questionsIds().stream()
                .forEach(questionId -> {
                    Question question = (Question) Question
                            .findByIdOptional(questionId)
                            .orElseThrow(() -> new InputValidationException("Disciplina não encontrada"));
                    exam.getQuestions().add(question);
                });

        exam.persist();
    }

}
