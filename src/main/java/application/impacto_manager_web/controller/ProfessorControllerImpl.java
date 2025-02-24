package application.impacto_manager_web.controller;

import application.controller.ProfessorApi;
import application.impacto_manager_web.exceptions.CustomException;
import application.impacto_manager_web.mapper.ProfessorMapper;
import application.impacto_manager_web.model.Professor;
import application.impacto_manager_web.model.ProfessorGenerated;
import application.impacto_manager_web.repository.ProfessorRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static application.impacto_manager_web.exceptions.ExceptionBuildMessage.errorBuildMessage;
import static application.impacto_manager_web.utils.ResponseEntityUtils.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Professor")
@AllArgsConstructor
public class ProfessorControllerImpl implements ProfessorApi {
    private final ProfessorRepository repository;

    @Override
    public ResponseEntity<ProfessorGenerated> createProfessor(ProfessorGenerated body) {
        Professor professor = new Professor();
        BeanUtils.copyProperties(body, professor);
        return created(ProfessorMapper.INSTANCE.toProfessorGenerated(professor), professor, repository);
    }

    @Override
    public ResponseEntity<Void> deleteProfessor(Long id) {
        return delete(repository,Professor.class, id);
    }

    @Override
    public ResponseEntity<List<ProfessorGenerated>> getAllProfessores() {
        return ok(ProfessorMapper.INSTANCE.toProfessorGeneratedList(repository.findAll()));
    }

    @Override
    public ResponseEntity<ProfessorGenerated> getProfessorById(Long id) {
        return ok(ProfessorMapper.INSTANCE.toProfessorGenerated(repository.findById(id).orElse(null)), id);
    }

    @Override
    public ResponseEntity<ProfessorGenerated> updateProfessor(ProfessorGenerated body) {
        Professor professor = repository.findById(body.getId())
            .orElseThrow(() ->
                new CustomException(Professor.class).addError(errorBuildMessage(Professor.class, body.getId()))
            );

        BeanUtils.copyProperties(body, professor, "id");
        Professor updatedProfessor = repository.save(professor);
        ProfessorGenerated updatedProfessorGenerated = ProfessorMapper.INSTANCE.toProfessorGenerated(updatedProfessor);
        return ok(updatedProfessorGenerated);
    }
}