package application.impacto_manager_web.utils;

import application.impacto_manager_web.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetDBConnection {
    private final AlunoRepository respository;

    @Scheduled(cron = "0 0 12 * * ?")
    private void getDB(){
        respository.findAll();
    }
}