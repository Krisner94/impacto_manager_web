package application.impacto_manager_web.model;

import application.impacto_manager_web.CEP.CEP_Service;
import application.impacto_manager_web.CEP.Endereco;
import application.impacto_manager_web.enums.SexoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aluno")
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
    private List<Turma> turmas = new ArrayList<>();

    public Aluno() {
    }

    public Aluno(String bairro, String cep, String cidade, String complemento, String cpf, LocalDate data_nascimento, String nome, String numero_casa, String responsavel_01, String responsavel_02, String rua, SexoEnum sexo, String telefone, String telefone_responsavel_01, String telefone_responsavel_02, List<Turma> turmas) {
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.complemento = complemento;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.nome = nome;
        this.numero_casa = numero_casa;
        this.responsavel_01 = responsavel_01;
        this.responsavel_02 = responsavel_02;
        this.rua = rua;
        this.sexo = sexo;
        this.telefone = telefone;
        this.telefone_responsavel_01 = telefone_responsavel_01;
        this.telefone_responsavel_02 = telefone_responsavel_02;
        this.turmas = turmas;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero_casa() {
        return numero_casa;
    }

    public void setNumero_casa(String numero_casa) {
        this.numero_casa = numero_casa;
    }

    public String getResponsavel_01() {
        return responsavel_01;
    }

    public void setResponsavel_01(String responsavel_01) {
        this.responsavel_01 = responsavel_01;
    }

    public String getTelefone_responsavel_01() {
        return telefone_responsavel_01;
    }

    public void setTelefone_responsavel_01(String telefone_responsavel_01) {
        this.telefone_responsavel_01 = telefone_responsavel_01;
    }

    public String getResponsavel_02() {
        return responsavel_02;
    }

    public void setResponsavel_02(String responsavel_02) {
        this.responsavel_02 = responsavel_02;
    }

    public String getTelefone_responsavel_02() {
        return telefone_responsavel_02;
    }

    public void setTelefone_responsavel_02(String telefone_responsavel_02) {
        this.telefone_responsavel_02 = telefone_responsavel_02;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
