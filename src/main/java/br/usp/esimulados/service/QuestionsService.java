package br.usp.esimulados.service;

import br.usp.esimulados.exception.ObjectNotFoundException;
import br.usp.esimulados.model.questions.Comment;
import br.usp.esimulados.model.questions.Question;
import br.usp.esimulados.model.questions.QuestionAlternative;
import br.usp.esimulados.model.questions.QuestionHistory;
import br.usp.esimulados.model.questions.dto.CreateCommentDTO;
import br.usp.esimulados.model.questions.dto.CreateQuestionAlternativeDTO;
import br.usp.esimulados.model.questions.dto.CreateQuestionDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class QuestionsService {

    @Inject
    EntityMapper entityMapper;

    public Question createQuestion(CreateQuestionDTO newQuestion) {
        Question question = entityMapper.createQuestionToQuestion(newQuestion);

        // Mapeamento manual das alternativas
        List<QuestionAlternative> alternatives = newQuestion.questionAlternatives()
                .stream()
                .map(entityMapper::createQuestionAlternativeToQuestionAlternative)
                .collect(Collectors.toList());

        question.setAlternatives(alternatives);

        log.info("Creating question: {}", question);
        question.persist();
        return question;
    }

    public void addComment(Long questionId, CreateCommentDTO newComment) {
        Question question = Optional
                .ofNullable((Question) Question.findById(questionId))
                .orElseThrow(() -> new ObjectNotFoundException("Question not found"));

        Comment comment = entityMapper.createCommentToComment(newComment);
        List<Comment> questionComments = question.getComments();
        questionComments.add(comment);
        question.setUpdatedAt(LocalDateTime.now());
    }

    public void deleteComment(Long questionId, UUID commentId) {

        Question question = Optional
                .ofNullable((Question) Question.findById(questionId))
                .orElseThrow(() -> new ObjectNotFoundException("Question not found"));

        Comment comment = question
                .getComments()
                .stream()
                .filter(commentCandidate -> commentCandidate.getUuid().equals(commentId))
                .findFirst()
                .orElseThrow(() -> new ObjectNotFoundException("Comment not found"));

        question.getComments().remove(comment);
        question.setUpdatedAt(LocalDateTime.now());

    }
}
