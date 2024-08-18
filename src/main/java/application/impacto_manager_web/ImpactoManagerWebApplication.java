package application.impacto_manager_web;

import application.impacto_manager_web.enums.DiaDaSemanaEnum;
import application.impacto_manager_web.model.Professor;
import application.impacto_manager_web.model.Turma;
import application.impacto_manager_web.repository.ProfessorRepository;
import application.impacto_manager_web.repository.TurmaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImpactoManagerWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImpactoManagerWebApplication.class, args);
    }
}

