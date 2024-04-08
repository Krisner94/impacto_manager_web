package application.impacto_manager_web.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Shutdown {
    @PostMapping("/shutdown")
    @Operation(summary = "Desligar", description = "Desligar servidor SpringBoot", tags = "Desligar")
    public void shutdownServer() {
        System.exit(0);
    }
}
