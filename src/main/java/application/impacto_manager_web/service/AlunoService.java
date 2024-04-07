package application.impacto_manager_web.service;

import application.impacto_manager_web.model.Aluno;
import application.impacto_manager_web.repository.AlunoRepository;
import org.springframework.stereotype.Service;

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

    public Aluno update(Long id, Aluno aluno){
        return repository.findById(id).map(p -> {
            p.setNome(aluno.getNome());
            p.setCpf(aluno.getCpf());
            p.setSexo(aluno.getSexo());
            p.setData_nascimento(aluno.getData_nascimento());
            p.setTelefone(aluno.getTelefone());
            p.setCep(aluno.getCep());
            p.setRua(aluno.getRua());
            p.setBairro(aluno.getBairro());
            p.setCidade(aluno.getCidade());
            p.setNumero_casa(aluno.getNumero_casa());
            p.setResponsavel_01(aluno.getResponsavel_01());
            p.setTelefone_responsavel_01(aluno.getTelefone_responsavel_01());
            p.setResponsavel_02(aluno.getResponsavel_02());
            p.setTelefone_responsavel_02(aluno.getTelefone_responsavel_02());
            return repository.save(p);
        }).orElseThrow();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
