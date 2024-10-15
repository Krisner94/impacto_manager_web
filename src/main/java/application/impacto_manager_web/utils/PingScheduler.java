package application.impacto_manager_web.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import application.impacto_manager_web.service.AlunoService;
import application.impacto_manager_web.service.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@EnableScheduling
@RequiredArgsConstructor
public class PingScheduler {
    private final TurmaService service;

    // Cron expression to schedule every 15 minutes (adjust as needed)
    @Scheduled(cron = "*/5 * * * * *")
    public void pingHost() {
        log.info("{}",service.findAll());
    }
}