package application.impacto_manager_web.mapper;

import application.impacto_manager_web.model.Professor;
import application.impacto_manager_web.model.ProfessorGenerated;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProfessorMapper {
    ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);
    ProfessorGenerated toProfessorGenerated(Professor professor);
    List<ProfessorGenerated> toProfessorGeneratedList(List<Professor> professores);
}
