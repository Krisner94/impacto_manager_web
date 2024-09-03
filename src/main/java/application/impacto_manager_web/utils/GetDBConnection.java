package application.impacto_manager_web.utils;

import application.impacto_manager_web.repository.AlunoRepository;
import application.impacto_manager_web.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableScheduling
@RequiredArgsConstructor
public class GetDBConnection {
    private final AlunoRepository respository;
    private final TurmaRepository turmaRepository;

    @Scheduled(cron = "0 0 12 * * ?")
    private void getDB(){
        log.info("Chamada no banco de dados");
        respository.findAll();
    }
}