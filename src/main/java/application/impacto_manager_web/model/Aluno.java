package application.impacto_manager_web.model;

import application.impacto_manager_web.enums.SexoEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aluno")
@SequenceGenerator(name = "seq_aluno", sequenceName = "seq_aluno", initialValue = 1000, allocationSize = 1)
public class Aluno implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String numero_casa;

    private String responsavel_01;
    @Column(length = 11)
    private String telefone_responsavel_01;
    private String responsavel_02;
    @Column(length = 11)
    private String telefone_responsavel_02;

}
