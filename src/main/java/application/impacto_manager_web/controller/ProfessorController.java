package application.impacto_manager_web.controller;

import application.impacto_manager_web.model.Professor;
import application.impacto_manager_web.service.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping({"","/"})
    @Operation(summary = "Buscar professores", description = "Busca todos os professores", tags = "Professor")
    public List<Professor> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar professores por id", description = "Busca professores por id", tags = "Professor")
    public Professor findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Cria professor", description = "Adicionar novo professor", tags = "Professor")
    public ResponseEntity<Professor> create(@RequestBody Professor professor){
        Professor novoProfessor = service.save(professor);
        return ResponseEntity.ok(novoProfessor);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar dados", description = "Editar dados de professores", tags = "Professor")
    public Professor update(@RequestBody Professor professor){
        Long id = professor.getId();
        return service.update(id, professor);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir professor", description = "Excluir professor", tags = "Professor")
    public ResponseEntity<Void> delete(@RequestHeader @PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
