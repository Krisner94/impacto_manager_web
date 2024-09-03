package application.impacto_manager_web.controller;

import application.impacto_manager_web.model.Aluno;
import application.impacto_manager_web.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
@Tag(name = "Alunos")
public class AlunoController {
    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping({"", "/"})
    @Operation(summary = "Buscar alunos")
    public List<Aluno> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar alunos por id")
    public Aluno findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Novo Aluno")
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) {
        Aluno novoAluno = service.save(aluno);
        return ResponseEntity.ok(novoAluno);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar dados")
    public Aluno update(@RequestBody Aluno aluno) {
        Long id = aluno.getId();
        return service.update(id, aluno);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui aluno")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
