package br.usp.esimulados.model.common;

import br.usp.esimulados.common.entity.ExtendedEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <b>Project</b>: e-simulados <br>
 * <b>Package</b>: br.usp.esimulados.model.common <br>
 * <b>User</b>: Vinicius Santana <br>
 * <b>Date</b>: 11/6/2024
 * <b>Time</b>: 9:02 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
@Entity(name = "disciplines")
public class Discipline extends ExtendedEntity {

    private String name;

    private boolean active = true;
    private UUID uuid = UUID.randomUUID();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}  