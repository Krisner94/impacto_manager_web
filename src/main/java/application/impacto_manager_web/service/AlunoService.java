package application.impacto_manager_web.service;

import application.impacto_manager_web.exceptions.NotFoundException;
import application.impacto_manager_web.model.Aluno;
import application.impacto_manager_web.repository.AlunoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<Aluno> findAll(){
        return repository.findAll();
    }

    public Aluno findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Aluno save(Aluno aluno){
        return repository.save(aluno);
    }

    public Aluno update(Long id, Aluno aluno) throws NotFoundException {
        return repository.findById(id)
                .map(alunoExistente -> {
                    BeanUtils.copyProperties(aluno, alunoExistente, "id");
                    return repository.save(alunoExistente);
                })
                .orElseThrow(() -> new NotFoundException(Aluno.class, id));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
