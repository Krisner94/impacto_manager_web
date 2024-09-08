package application.impacto_manager_web.controller;

import application.impacto_manager_web.AlunoFaker;
import application.impacto_manager_web.model.Aluno;
import application.impacto_manager_web.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Alunos")
@RestController
@RequestMapping("/api/aluno")
@AllArgsConstructor
public class AlunoController {
    private final AlunoService service;
    private final AlunoFaker alunoFaker;


    @GetMapping({"", "/"})
    @Operation(summary = "Buscar alunos", description = "Busca todos os alunos", tags = "Alunos")
    public List<Aluno> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar alunos por id")
    public Aluno findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Aluno>> findPage (
            Model model,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Aluno> alunos = service.findPage(page, linesPerPage, orderBy, direction);
        model.addAttribute("alunos", alunos);
        return ResponseEntity.ok(alunos);

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
