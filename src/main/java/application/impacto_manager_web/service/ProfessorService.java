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
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar todos os professores", e);
        }
    }

    public Professor findById(Long id){
        try {
            return repository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar professor por ID", e);
        }
    }

    public Professor save(Professor professor){
        try {
            return repository.save(professor);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar professor", e);
        }
    }

    public Professor update(Long id, Professor professor){
        try {
            return repository.findById(id).map(p -> {
                p.setNome(professor.getNome());
                p.setSexo(professor.getSexo());
                p.setCpf(professor.getCpf());
                return repository.save(p);
            }).orElseThrow();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar professor", e);
        }
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar professor", e);
        }
    }
}