package application.impacto_manager_web.controller;

import application.controller.AlunosApi;
import application.impacto_manager_web.exceptions.CustomException;
import application.impacto_manager_web.exceptions.Error;
import application.impacto_manager_web.mapper.AlunoMapper;
import application.impacto_manager_web.model.Aluno;
import application.impacto_manager_web.model.AlunoGenerated;
import application.impacto_manager_web.repository.AlunoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static application.impacto_manager_web.exceptions.ExceptionBuildMessage.errorBuildMessage;
import static application.impacto_manager_web.utils.ResponseEntityUtils.responseEntity;

@Tag(name = "Alunos")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AlunoControllerImpl implements AlunosApi {
    private final AlunoRepository repository;
    private List<Error> errors = new ArrayList<>();
    //private final AlunoFaker alunoFaker;

    @Override
    public ResponseEntity<List<AlunoGenerated>> getAllAlunos() {
        List<AlunoGenerated> alunosGenerated = AlunoMapper.INSTANCE.toAlunoGeneratedList(repository.findAll());
        return responseEntity(alunosGenerated);
    }

    @Override
    public ResponseEntity<AlunoGenerated> createAluno(AlunoGenerated body) {
        AlunoGenerated novoAluno = AlunoMapper.INSTANCE.toAlunoGenerated(Aluno.builder().build());
        return responseEntity(novoAluno);
    }

    @Override
    public ResponseEntity<Void> deleteAluno(Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<AlunoGenerated> getAlunoById(Long id){
        errors.add(Error.builder()
            .title("Professor não encontrado")
            .message("O professor com o ID " + id + " não foi encontrado.")
            .httpStatus(HttpStatus.NOT_FOUND.name())
            .build());
        Aluno aluno = repository.findById(id).orElseThrow(() ->
            new CustomException(Aluno.class).addError(errorBuildMessage(Aluno.class, id)));
        AlunoGenerated alunoGenerated = AlunoMapper.INSTANCE.toAlunoGenerated(aluno);
        return responseEntity(alunoGenerated);
    }

    @Override
    public ResponseEntity<AlunoGenerated> updateAluno(AlunoGenerated body) {
        Aluno aluno = repository.findById(body.getId()).orElseThrow(() ->
            new CustomException(Aluno.class).addError(errorBuildMessage(Aluno.class, body.getId())));

        BeanUtils.copyProperties(body, aluno, "id");
        Aluno updateAluno = repository.save(aluno);
        AlunoGenerated updateAlunoGenerated = AlunoMapper.INSTANCE.toAlunoGenerated(updateAluno);
        return responseEntity(updateAlunoGenerated);
    }
}

