package application.impacto_manager_web.service;

import application.impacto_manager_web.model.Turma;
import application.impacto_manager_web.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {
    private final TurmaRepository repository;

    public List<Turma> findAll(){
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar todas as turmas", e);
        }
    }

    public Turma findById(Long id){
        try {
            return repository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar turma por ID", e);
        }
    }

    public Turma save(Turma turma){
        try {
            return repository.save(turma);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar turma", e);
        }
    }

    public Turma update(Long id, Turma turma){
        try {
            return repository.findById(id).map(t -> {
                t.setNome(turma.getNome());
                t.setDia01(turma.getDia01());
                t.setDia02(turma.getDia02());
                t.setHorario(turma.getHorario());
                t.setAlunos(turma.getAlunos());
                return repository.save(t);
            }).orElseThrow();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar turma", e);
        }
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar turma", e);
        }
    }
}