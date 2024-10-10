package application.impacto_manager_web.controller;

import application.impacto_manager_web.exceptions.NotFoundException;
import application.impacto_manager_web.model.Professor;
import application.impacto_manager_web.service.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
@Tag(name = "Professor")
public class ProfessorController {
    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping({"","/"})
    @Operation(summary = "Busca todos os professores existentes")
    public List<Professor> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar professores por id", description = "Busca professores por id", tags = "Professor")
    public Professor findById(@RequestHeader Long id){
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Adiciona um professor")
    public ResponseEntity<Professor> create(@RequestBody Professor professor){
        Professor novoProfessor = service.save(professor);
        return ResponseEntity.ok(novoProfessor);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um professor")
    public Professor update(@RequestBody Professor professor) throws NotFoundException {
        Long id = professor.getId();
        return service.update(id, professor);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir professor")
    public ResponseEntity<Void> delete(@RequestHeader @PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
