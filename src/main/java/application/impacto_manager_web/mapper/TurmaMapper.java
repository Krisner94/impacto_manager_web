package application.impacto_manager_web.mapper;

import application.impacto_manager_web.model.Turma;
import application.impacto_manager_web.model.TurmaGenerated;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TurmaMapper {
    TurmaMapper INSTANCE = Mappers.getMapper(TurmaMapper.class);
    TurmaGenerated toTurmaGenerated(Turma turma);
    List<TurmaGenerated> toTurmaGeneratedList(List<Turma> Turmas);
}
