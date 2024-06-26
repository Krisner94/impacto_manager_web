package application.impacto_manager_web;

import application.impacto_manager_web.enums.DiaDaSemanaEnum;
import application.impacto_manager_web.model.Professor;
import application.impacto_manager_web.model.Turma;
import application.impacto_manager_web.repository.ProfessorRepository;
import application.impacto_manager_web.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class ImpactoManagerWebApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ImpactoManagerWebApplication.class, args);
    }

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    TurmaRepository turmaRepository;

    @Override
    public void run(String... args) throws Exception {
        Professor professor1  = new Professor(null, "Jose");
        Turma turma1 = new Turma(null, "Turma 1","12:00", DiaDaSemanaEnum.SEGUNDA, DiaDaSemanaEnum.QUARTA);


        professor1.getTurmas().add(turma1);
        turma1.getProfessores().add(professor1);

        professorRepository.save(professor1);
        turmaRepository.save(turma1);
    }
}

