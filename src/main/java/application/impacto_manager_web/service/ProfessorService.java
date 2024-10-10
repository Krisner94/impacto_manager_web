package application.impacto_manager_web.service;

import application.impacto_manager_web.exceptions.NotFoundException;
import application.impacto_manager_web.model.Aluno;
import application.impacto_manager_web.model.Professor;
import application.impacto_manager_web.repository.ProfessorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private ProfessorRepository repository;

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

    public Professor update(Long id, Professor professor) throws NotFoundException {
        return repository.findById(id)
                .map(professorExistente -> {
                    BeanUtils.copyProperties(professor, professorExistente, "id");
                    return repository.save(professorExistente);
                })
                .orElseThrow(() -> new NotFoundException(Professor.class, id));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
