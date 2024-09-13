package br.usp.esimulados.model.user;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User extends PanacheEntity {
    // google
    private String name;
    private String email;
    private String imageUrl;

    private UserRole role;
    private UUID organizationId;
    private boolean active;

    private List<String> favoriteExams;

}
