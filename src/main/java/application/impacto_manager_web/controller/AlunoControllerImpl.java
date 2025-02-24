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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static application.impacto_manager_web.exceptions.ExceptionBuildMessage.errorBuildMessage;
import static application.impacto_manager_web.utils.ResponseEntityUtils.*;

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
        return ok(AlunoMapper.INSTANCE.toAlunoGeneratedList(repository.findAll()));
    }

    @Override
    public ResponseEntity<AlunoGenerated> createAluno(AlunoGenerated body) {
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(body, aluno);
        return created(AlunoMapper.INSTANCE.toAlunoGenerated(aluno), aluno, repository);
    }

    @Override
    public ResponseEntity<Void> deleteAluno(Long id) {
        return delete(repository, Aluno.class, id);
    }

    @Override
    public ResponseEntity<AlunoGenerated> getAlunoById(Long id) {
        Optional<Aluno> aluno = repository.findById(id);
        AlunoGenerated alunoGenerated = AlunoMapper.INSTANCE.toAlunoGenerated(aluno.orElse(null));

        return ok(alunoGenerated, id);
    }

    @Override
    public ResponseEntity<AlunoGenerated> updateAluno(AlunoGenerated body) {
        Aluno aluno = repository.findById(body.getId()).orElseThrow(() ->
            new CustomException(Aluno.class).addError(errorBuildMessage(Aluno.class, body.getId())));

        BeanUtils.copyProperties(body, aluno, "id");
        Aluno updateAluno = repository.save(aluno);
        AlunoGenerated updateAlunoGenerated = AlunoMapper.INSTANCE.toAlunoGenerated(updateAluno);
        return ok(updateAlunoGenerated);
    }
}

