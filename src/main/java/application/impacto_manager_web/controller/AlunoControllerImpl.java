package application.impacto_manager_web.controller;

import application.controller.AlunosApi;
import application.impacto_manager_web.mapper.AlunoMapper;
import application.impacto_manager_web.model.Aluno;
import application.impacto_manager_web.model.AlunoGenerated;
import application.impacto_manager_web.repository.AlunoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static application.impacto_manager_web.utils.ResponseEntityUtils.objectResponseEntity;

@Tag(name = "Alunos")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AlunoControllerImpl implements AlunosApi {
    private final AlunoRepository repository;
    private final AlunoRepository alunoRepository;
    //private final AlunoFaker alunoFaker;

    @Override
    public ResponseEntity<List<AlunoGenerated>> getAllAlunos() {
        List<AlunoGenerated> alunosGenerated = AlunoMapper.INSTANCE.toAlunoGeneratedList(repository.findAll());
        return objectResponseEntity(alunosGenerated);
    }

    @Override
    public ResponseEntity<AlunoGenerated> createAluno(AlunoGenerated body) {
        AlunoGenerated novoAluno = AlunoMapper.INSTANCE.toAlunoGenerated(Aluno.builder().build());
        return objectResponseEntity(novoAluno);
    }

    @Override
    public ResponseEntity<Void> deleteAluno(Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<AlunoGenerated> getAlunoById(Long id) {
        AlunoGenerated alunoGenerated = AlunoMapper.INSTANCE.toAlunoGenerated(repository.findById(id).get());
        return objectResponseEntity(alunoGenerated);
    }

    @Override
    public ResponseEntity<AlunoGenerated> updateAluno(AlunoGenerated body) {
        repository.findById(body.getId()).map(p -> {
            BeanUtils.copyProperties(body, p, "id");
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Aluno not found"));
        return ResponseEntity.ok().build();
    }
}

