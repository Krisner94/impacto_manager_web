package application.impacto_manager_web.controller;

import application.impacto_manager_web.model.Aluno;
import application.impacto_manager_web.model.Professor;
import application.impacto_manager_web.service.ProfessorService;
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
    public List<Professor> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Professor findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Professor> create(@RequestBody Professor professor){
        Professor novoProfessor = service.save(professor);
        return ResponseEntity.ok(novoProfessor);
    }

    @PutMapping("/{id}")
    public Professor update(@PathVariable Long id, @RequestBody Professor professor){
        return service.update(id, professor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
