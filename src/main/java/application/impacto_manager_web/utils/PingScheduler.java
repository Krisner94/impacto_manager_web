package application.impacto_manager_web.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@Component
@EnableScheduling
@RequiredArgsConstructor
public class PingScheduler {

    @Scheduled(fixedRate = 180000) // A cada 180.000 milissegundos (3 minutos)
    public void pingHost() {
        String host = "www.google.com"; // Substitua pelo host desejado

        try {
            InetAddress address = InetAddress.getByName(host);
            boolean reachable = address.isReachable(5000); // Timeout de 5 segundos

            if (reachable) {
                log.info("{} é alcançavel", host);
            } else {
                log.info("{} não é alcançavel", host);
            }
        } catch (UnknownHostException ex) {
            log.info("Host desconhecido {}", ex.getMessage());
        } catch (IOException ex) {
            log.info("Erro de I/O: {}", ex.getMessage());
        }
    }
}