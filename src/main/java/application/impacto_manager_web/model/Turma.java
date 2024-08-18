package application.impacto_manager_web.model;

import application.impacto_manager_web.enums.DiaDaSemanaEnum;
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
    private Integer dia01, dia02;
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

    public Turma(Long id, String nome, String horario, DiaDaSemanaEnum dia01, DiaDaSemanaEnum dia02) {
        this.id = id;
        this.nome = nome;
        this.horario = horario;
        this.dia01 = dia01.getCod();
        this.dia02 = dia02.getCod();
    }

    public DiaDaSemanaEnum getDia01() {
        return DiaDaSemanaEnum.toEnum(dia01);
    }

    public void setDia01(DiaDaSemanaEnum dia01) {
        this.dia01 = dia01.getCod();
    }

    public DiaDaSemanaEnum getDia02() {
        return DiaDaSemanaEnum.toEnum(dia02);
    }

    public void setDia02(DiaDaSemanaEnum dia02) {
        this.dia02 = dia02.getCod();
    }

}
