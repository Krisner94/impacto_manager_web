package application.impacto_manager_web.controller;

import application.impacto_manager_web.AlunoFaker;
import application.impacto_manager_web.model.Aluno;
import application.impacto_manager_web.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
@Tag(name = "Alunos")
public class AlunoController {
    private final AlunoService service;
    private final AlunoFaker alunoFaker;

    @Autowired
    public AlunoController(AlunoService service, AlunoFaker alunoFaker) {
        this.service = service;
        this.alunoFaker = alunoFaker;
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

    @PostMapping("/fake")
    @Operation(summary = "Adicionar alunos fake")
    public ResponseEntity<Void> addFakeAlunos(@RequestParam int quantidade) {
        alunoFaker.insertFakeAlunosIntoDatabase(quantidade);
        return ResponseEntity.ok().build();
    }
}
