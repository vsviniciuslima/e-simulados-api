package br.usp.esimulados.model.questions;

import java.util.List;
import java.util.UUID;

public record QuestionAlternative(
    List<String> imageUrls,
    String content,
    boolean correct,
    UUID uuid
) { }
