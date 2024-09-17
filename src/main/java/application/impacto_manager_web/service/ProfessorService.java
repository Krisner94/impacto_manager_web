package application.impacto_manager_web.service;

import application.impacto_manager_web.model.Professor;
import application.impacto_manager_web.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public List<Professor> findAll(){
        return repository.findAll();
    }

    public Professor findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Professor save(Professor professor){
        return repository.save(professor);
    }

    public Professor update(Long id, Professor professor){
        return repository.findById(id).map(p -> {
            p.setNome(professor.getNome());
            p.setSexo(professor.getSexo());
            p.setCpf(professor.getCpf());
            return repository.save(p);
        }).orElseThrow();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
