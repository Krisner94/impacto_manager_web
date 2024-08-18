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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private LocalDate dataNascimento;
    @Column(length = 11)
    private String telefone;

    @Column(nullable = false)
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    @Column(nullable = false)
    private String numeroCasa;
    private String complemento;

    private String responsavel01;
    @Column(length = 11)
    private String telefoneResponsavel01;
    private String responsavel02;
    @Column(length = 11)
    private String telefoneResponsavel02;

    @ManyToMany(mappedBy = "alunos")
    @JsonIgnore
    private List<Turma> turmas;
}
