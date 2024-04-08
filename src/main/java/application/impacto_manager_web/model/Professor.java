package application.impacto_manager_web.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "professores")
public class Professor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String nome;

    public Professor(String nome) {
        this.nome = nome;
    }

    public Professor() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
