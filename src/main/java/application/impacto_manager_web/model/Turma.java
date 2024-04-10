package application.impacto_manager_web.model;

import application.impacto_manager_web.enums.DiaDaSemanaEnum;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "turma")
public class Turma implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private DiaDaSemanaEnum dia01, dia02;
    private Instant horario;

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

    public Turma() {
    }

    public Turma(String nome, DiaDaSemanaEnum dia01, DiaDaSemanaEnum dia02, Instant horario) {
        this.nome = nome;
        this.dia01 = dia01;
        this.dia02 = dia02;
        this.horario = horario;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public DiaDaSemanaEnum getDia01() {
        return dia01;
    }

    public void setDia01(DiaDaSemanaEnum dia01) {
        this.dia01 = dia01;
    }

    public DiaDaSemanaEnum getDia02() {
        return dia02;
    }

    public void setDia02(DiaDaSemanaEnum dia02) {
        this.dia02 = dia02;
    }

    public Instant getHorario() {
        return horario;
    }

    public void setHorario(Instant horario) {
        this.horario = horario;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }
}
