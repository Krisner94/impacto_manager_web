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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static application.impacto_manager_web.exceptions.ExceptionBuildMessage.errorBuildMessage;
import static application.impacto_manager_web.utils.ResponseEntityUtils.created;

@RestController
@RequestMapping("/api")
@Tag(name = "Professor")
@AllArgsConstructor
public class ProfessorControllerImpl implements ProfessorApi {
    private final ProfessorRepository repository;

    @Override
    public ResponseEntity<ProfessorGenerated> createProfessor(ProfessorGenerated body) {
        return created(ProfessorMapper.INSTANCE.toProfessorGenerated(new Professor()));
    }

    @Override
    public ResponseEntity<Void> deleteProfessor(Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<ProfessorGenerated>> getAllProfessores() {
        return ResponseEntity.ok(ProfessorMapper.INSTANCE.toProfessorGeneratedList(repository.findAll()));
    }

    @Override
    public ResponseEntity<ProfessorGenerated> getProfessorById(Long id) {
        Professor professor = repository.findById(id)
            .orElseThrow(() ->
                new CustomException(Professor.class).addError(errorBuildMessage(Professor.class, id))
            );

        return ResponseEntity.ok(ProfessorMapper.INSTANCE.toProfessorGenerated(professor));
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
        return ResponseEntity.ok(updatedProfessorGenerated);
    }
}