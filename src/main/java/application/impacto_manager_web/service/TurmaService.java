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
        return repository.findAll();
    }

    public Turma findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Turma save(Turma turma){
        return repository.save(turma);
    }

    public Turma update(Long id, Turma turma){
        return repository.findById(id).map(t -> {
            t.setNome(turma.getNome());
            t.setDia01(turma.getDia01());
            t.setDia02(turma.getDia02());
            t.setHorario(turma.getHorario());
            t.setAlunos(turma.getAlunos());
            return repository.save(t);
        }).orElseThrow();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
