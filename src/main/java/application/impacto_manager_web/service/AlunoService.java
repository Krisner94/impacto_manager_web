package application.impacto_manager_web.service;

import application.impacto_manager_web.model.Aluno;
import application.impacto_manager_web.repository.AlunoRepository;
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

    public List<Aluno> findByNomeOrCpf(String nome, String cpf){
        return repository.findByNomeOrCpf(nome, cpf);
    }

    public Aluno save(Aluno aluno){
        return repository.save(aluno);
    }

    public Aluno update(Long id, Aluno aluno){
        return repository.findById(id).map(p -> {
            p.setNome(aluno.getNome());
            p.setCpf(aluno.getCpf());
            p.setSexo(aluno.getSexo());
            p.setDataNascimento(aluno.getDataNascimento());
            p.setTelefone(aluno.getTelefone());
            p.setCep(aluno.getCep());
            p.setRua(aluno.getRua());
            p.setBairro(aluno.getBairro());
            p.setCidade(aluno.getCidade());
            p.setNumeroCasa(aluno.getNumeroCasa());
            p.setResponsavel01(aluno.getResponsavel01());
            p.setTelefoneResponsavel01(aluno.getTelefoneResponsavel01());
            p.setResponsavel02(aluno.getResponsavel02());
            p.setTelefoneResponsavel02(aluno.getTelefoneResponsavel02());
            p.setComplemento(aluno.getComplemento());
            return repository.save(p);
        }).orElseThrow();
    }

    public Page<Aluno> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        Pageable pageable = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageable);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
