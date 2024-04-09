package application.impacto_manager_web.controller;

import application.impacto_manager_web.model.Aluno;
import application.impacto_manager_web.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping({"", "/"})
    @Operation(summary = "Buscar alunos", description = "Busca todos os alunos", tags = "Alunos")
    public List<Aluno> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar alunos por id", description = "Busca aluno por id", tags = "Alunos")
    public Aluno findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Novo Aluno", description = "Criar novo aluno", tags = "Alunos")
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) {
        Aluno novoAluno = service.save(aluno);
        return ResponseEntity.ok(novoAluno);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar dados", description = "Editar dados de alunos", tags = "Alunos")
    public Aluno update(@PathVariable Long id, @RequestBody Aluno aluno) {
        return service.update(id, aluno);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui aluno", description = "Exclui dados de alunos", tags = "Alunos")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
