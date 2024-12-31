package br.usp.esimulados.model.exam.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CreateExamDTOClass {
    @NotEmpty(message = "É necessário adicionar ao menos uma questão ao simulado.")
    private List<String> questionIds;

    private List<String> tags;
    private @NotNull String category;
    private @NotNull String subCategory;
    private @NotNull String author;
    private @NotNull String authorId;
    private @NotNull String name;
    private @NotNull String description;
    private @NotNull String imageUrl;
}
