package application.impacto_manager_web.utils;

import application.impacto_manager_web.model.Turma;
import application.impacto_manager_web.service.TurmaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Slf4j
@Component
@EnableScheduling
@RequiredArgsConstructor
public class PingScheduler {

    private final TurmaService turmaService;

    @Scheduled(fixedRate = 180000) // A cada 180.000 milissegundos (3 minutos)
    public void pingHost() {
        List<Turma> turmas = turmaService.findAll();
        log.info("Executed getAll on TurmaService. Fetched {} turmas.", turmas.size());

    }
}