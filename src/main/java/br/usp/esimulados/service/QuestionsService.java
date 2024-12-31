package br.usp.esimulados.service;

import br.usp.esimulados.exception.EntityNotFoundException;
import br.usp.esimulados.model.common.Discipline;
import br.usp.esimulados.model.common.Topic;
import br.usp.esimulados.model.questions.Comment;
import br.usp.esimulados.model.questions.Question;
import br.usp.esimulados.model.questions.QuestionAlternative;
import br.usp.esimulados.model.questions.dto.CreateCommentDTO;
import br.usp.esimulados.model.questions.dto.CreateQuestionDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service responsible for handling operations related to Questions and Comments.
 * It provides methods to create questions, add comments, and delete comments.
 *
 * This service is marked as {@link ApplicationScoped}, meaning it is a singleton
 * for the entire application runtime.
 */
@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class QuestionsService {

    /**
     * The {@link EntityMapper} is used to map DTOs to entities.
     */
    @Inject
    EntityMapper entityMapper;

    /**
     * Creates a new question from the provided {@link CreateQuestionDTO}.
     * The question is persisted in the database.
     *
     * @param newQuestion the data transfer object containing the information to create a question
     * @return the newly created {@link Question} entity
     */
    public Question createQuestion(CreateQuestionDTO newQuestion) {
        Question question = entityMapper.createQuestionToQuestion(newQuestion);

        Discipline.findByIdOptional(newQuestion.disciplineId())
                .ifPresentOrElse(discipline -> question.setDiscipline((Discipline) discipline), () -> {
                    throw new EntityNotFoundException("Discipline not found:" + newQuestion.disciplineId());
                });

        Topic.findByIdOptional(newQuestion.topicId())
                .ifPresentOrElse(discipline -> question.setTopic((Topic) discipline), () -> {
                    throw new EntityNotFoundException("Topic not found: " + newQuestion.topicId());
                });


        List<QuestionAlternative> questionAlternatives = newQuestion.questionAlternatives().stream()
                .map(entityMapper::createQuestionAlternativeToQuestionAlternative)
                .toList();
        question.setAlternatives(questionAlternatives);
        question.setComments(List.of());

        log.info("Creating question: {}", question);
        question.persist();
        return question;
    }

    /**
     * Adds a new comment to the question identified by the provided questionId.
     * The comment is created from the {@link CreateCommentDTO} and added to the question's comments list.
     *
     * @param questionId the ID of the question to which the comment will be added
     * @param newComment the data transfer object containing the comment's information
     * @throws EntityNotFoundException if the question with the provided ID is not found
     */
    public void addComment(Long questionId, CreateCommentDTO newComment) {
        Question question = Optional
                .ofNullable((Question) Question.findById(questionId))
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));

        Comment comment = entityMapper.createCommentToComment(newComment);
        List<Comment> questionComments = question.getComments();
        questionComments.add(comment);
//        question.setUpdatedAt(LocalDateTime.now());
    }

    /**
     * Deletes a comment from the question identified by the provided questionId and commentId.
     * The comment is removed from the question's comments list.
     *
     * @param questionId the ID of the question from which the comment will be deleted
     * @param commentId  the UUID of the comment to be deleted
     * @throws EntityNotFoundException if the question or comment with the provided IDs are not found
     */
    public void deleteComment(Long questionId, UUID commentId) {

        Question question = Optional
                .ofNullable((Question) Question.findById(questionId))
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));

        Comment comment = question
                .getComments()
                .stream()
                .filter(commentCandidate -> commentCandidate.getUuid().equals(commentId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));

        question.getComments().remove(comment);
//        question.setUpdatedAt(LocalDateTime.now());
    }
}
