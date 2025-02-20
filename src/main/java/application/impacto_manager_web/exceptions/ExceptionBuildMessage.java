package application.impacto_manager_web.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionBuildMessage {
    public static Error errorBuildMessage(Class<?> clazz, Long id) {
        return Error.builder()
            .title(clazz.getSimpleName() + " não encontrado")
            .message(clazz.getSimpleName() + " com o ID " + id + " não foi encontrado.")
            .httpStatus(String.valueOf(HttpStatus.NOT_FOUND.value()))
            .build();
    }
}
