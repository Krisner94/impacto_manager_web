package application.impacto_manager_web.service;

import application.impacto_manager_web.exceptions.NotFoundException;
import application.impacto_manager_web.model.Aluno;
import application.impacto_manager_web.model.Turma;
import application.impacto_manager_web.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {
    private final TurmaRepository repository;

    public TurmaService(TurmaRepository repository) {
        this.repository = repository;
    }

    public List<Turma> findAll(){
        return repository.findAll();
    }

    public Turma findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Turma save(Turma turma){
        return repository.save(turma);
    }

    public Turma update(Long id, Turma turma) throws NotFoundException {
        return repository.findById(id)
                .map(turmaExistente -> {
                    BeanUtils.copyProperties(turma, turmaExistente, "id");
                    return repository.save(turmaExistente);
                })
                .orElseThrow(() -> new NotFoundException(Turma.class, id));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}