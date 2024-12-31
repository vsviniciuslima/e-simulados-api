package br.usp.esimulados.model.questions;

import java.util.List;
import java.util.UUID;

public record QuestionAlternative(
    String label,
    List<String> imageUrls,
    String content
) { }
