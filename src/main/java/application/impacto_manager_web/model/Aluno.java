package application.impacto_manager_web.model;

import application.impacto_manager_web.enums.SexoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "aluno")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Aluno implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private SexoEnum sexo;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_nascimento;
    @Column(length = 11)
    private String telefone;

    @Column(nullable = false)
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    @Column(nullable = false)
    private String numero_casa;
    private String complemento;

    private String responsavel_01;
    @Column(length = 11)
    private String telefone_responsavel_01;
    private String responsavel_02;
    @Column(length = 11)
    private String telefone_responsavel_02;

    @ManyToMany(mappedBy = "alunos")
    @JsonIgnore
    private List<Turma> turmas;

}
