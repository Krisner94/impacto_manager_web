package application.impacto_manager_web.controller;

import application.impacto_manager_web.exceptions.NotFoundException;
import application.impacto_manager_web.model.Aluno;
import application.impacto_manager_web.model.Turma;
import application.impacto_manager_web.service.TurmaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turma")
@Tag(name = "Turmas")
public class TurmaController {
    private final TurmaService service;

    public TurmaController(TurmaService service) {
        this.service = service;
    }

    @GetMapping({"","/"})
    @Operation(summary = "Retorna todas as turmas")
    public List<Turma> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna uma turma específica")
    public Turma findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Cria uma nova turma")
    public ResponseEntity<Turma> create(@RequestBody Turma turma){
        Turma novaTurma = service.save(turma);
        return ResponseEntity.ok(novaTurma);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza os valores de uma turma existente")
    public Turma update(@RequestBody Turma turma) throws NotFoundException {
        Long id = turma.getId();
        return service.update(id, turma);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui uma turma existente")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
