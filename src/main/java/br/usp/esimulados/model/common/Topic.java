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
 * <b>Time</b>: 9:40 PM <br>
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "topics")
@RegisterForReflection
public class Topic extends ExtendedEntity {
    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;
    private String name;
}  