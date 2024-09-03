package application.impacto_manager_web.controller;

import application.impacto_manager_web.model.Professor;
import application.impacto_manager_web.service.ProfessorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
@Api(tags = "Professor")
public class ProfessorController {
    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping({"","/"})
    @ApiOperation(value = "Busca todos os professores existentes")
    public List<Professor> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca um professor específico")
    public Professor findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Adiciona um professor")
    public ResponseEntity<Professor> create(@RequestBody Professor professor){
        Professor novoProfessor = service.save(professor);
        return ResponseEntity.ok(novoProfessor);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um professor")
    public Professor update(@RequestBody Professor professor){
        Long id = professor.getId();
        return service.update(id, professor);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Excluir professor")
    public ResponseEntity<Void> delete(@RequestHeader @PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
