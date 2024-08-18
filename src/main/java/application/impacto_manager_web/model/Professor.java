package application.impacto_manager_web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professores")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Professor implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;


    @ManyToMany(mappedBy = "professores")
    @JsonIgnore
    private List<Turma> turmas = new ArrayList<>();

    public Professor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

}
