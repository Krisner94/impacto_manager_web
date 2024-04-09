package application.impacto_manager_web.model;

import application.impacto_manager_web.enums.DiaDaSemanaEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "turma")
public class Turma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private DiaDaSemanaEnum dia01, dia02;
    private Instant horario;

    @ManyToOne
    private Professor professor;
    @OneToMany(mappedBy = "turma")
    @JsonIgnore
    private List<Aluno> aluno;

    public Turma() {
    }

    public Turma(String nome, DiaDaSemanaEnum dia01, DiaDaSemanaEnum dia02, Instant horario, Professor professor, List<Aluno> aluno) {
        this.nome = nome;
        this.dia01 = dia01;
        this.dia02 = dia02;
        this.horario = horario;
        this.professor = professor;
        this.aluno = aluno;
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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAluno() {
        return aluno;
    }

    public void setAluno(List<Aluno> aluno) {
        this.aluno = aluno;
    }
}
