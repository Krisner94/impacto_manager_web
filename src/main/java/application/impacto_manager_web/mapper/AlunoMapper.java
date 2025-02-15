package application.impacto_manager_web.mapper;

import application.impacto_manager_web.model.Aluno;
import application.impacto_manager_web.model.AlunoGenerated;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AlunoMapper {
    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);
    AlunoGenerated toAlunoGenerated(Aluno aluno);
    List<AlunoGenerated> toAlunoGeneratedList(List<Aluno> alunos);
}
