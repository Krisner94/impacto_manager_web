package application.impacto_manager_web.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "turma")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Turma implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private String dia01;
    private String dia02;
    private String horario;

    @ManyToMany
    @JoinTable(
            name = "TurmasAlunos",
            //uniqueConstraints = @UniqueConstraint(columnNames = {"codigo_turma", "id_alunos"}),
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "alunos_id")
    )
    private List<Aluno> alunos = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "TurmasProfessores",
            //uniqueConstraints = @UniqueConstraint(columnNames = {"codigo_turma", "id_professor"}),
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    private List<Professor> professores = new ArrayList<>();
}
