package application.impacto_manager_web.controller;

import application.controller.TurmasApi;
import application.impacto_manager_web.exceptions.CustomException;
import application.impacto_manager_web.mapper.TurmaMapper;
import application.impacto_manager_web.model.Turma;
import application.impacto_manager_web.model.TurmaGenerated;
import application.impacto_manager_web.repository.TurmaRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static application.impacto_manager_web.exceptions.ExceptionBuildMessage.errorBuildMessage;
import static application.impacto_manager_web.utils.ResponseEntityUtils.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Turmas")
@AllArgsConstructor
public class TurmaControllerImpl implements TurmasApi {
    private final TurmaRepository repository;

    @Override
    public ResponseEntity<List<TurmaGenerated>> getAllTurmas() {
        return ok(TurmaMapper.INSTANCE.toTurmaGeneratedList(repository.findAll()));
    }

    @Override
    public ResponseEntity<TurmaGenerated> getTurmaById(Long id) {
        return ok(TurmaMapper.INSTANCE.toTurmaGenerated(repository.findById(id).orElse(null)), id);
    }

    @Override
    public ResponseEntity<TurmaGenerated> createTurma(TurmaGenerated body) {
        Turma turma = new Turma();
        BeanUtils.copyProperties(body, turma);
        return created(TurmaMapper.INSTANCE.toTurmaGenerated(turma), new Turma(), repository);
    }

    @Override
    public ResponseEntity<Void> deleteTurma(Long id) {
        return delete(repository, Turma.class, id);
    }


    @Override
    public ResponseEntity<TurmaGenerated> updateTurma(TurmaGenerated body) {
        Turma turma = repository.findById(body.getId()).orElseThrow(() ->
            new CustomException(Turma.class).addError(errorBuildMessage(Turma.class, body.getId())));


        BeanUtils.copyProperties(body, turma, "id");
        Turma updateTurma = repository.save(turma);
        TurmaGenerated updateTurmaGenerated = TurmaMapper.INSTANCE.toTurmaGenerated(updateTurma);
        return ok(updateTurmaGenerated);
    }
}
