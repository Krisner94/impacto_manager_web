package application.impacto_manager_web.repository;

import application.impacto_manager_web.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("SELECT a FROM Aluno a WHERE (:nome IS NULL OR LOWER(a.nome) LIKE %:nome%) AND (:cpf IS NULL OR a.cpf LIKE %:cpf%)")
    List<Aluno> findByNomeOrCpf(@Param("nome") String nome, @Param("cpf") String cpf);
}