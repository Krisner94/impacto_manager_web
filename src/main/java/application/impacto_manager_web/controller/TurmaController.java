package application.impacto_manager_web.controller;

import application.impacto_manager_web.model.Aluno;
import application.impacto_manager_web.model.Turma;
import application.impacto_manager_web.service.TurmaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {
    private final TurmaService service;

    public TurmaController(TurmaService service) {
        this.service = service;
    }

    @GetMapping({"","/"})
    @Operation(summary = "Buscar por id", description = "Buscar turmas por id", tags = "Turma")
    public List<Turma> findAll(){
        return service.findAll();
    }

    @PostMapping
    @Operation(summary = "Nova Turma", description = "Criar nova turma", tags = "Turma")
    public ResponseEntity<Turma> create(@RequestBody Turma turma){
        Turma novaTurma = service.save(turma);
        return ResponseEntity.ok(novaTurma);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar turma", description = "Atualizar dados de turma", tags = "Turma")
    public Turma update(@PathVariable Long id, @RequestBody Turma turma){
        return service.update(id, turma);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar turma", description = "Deletar turma", tags = "Turma")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
