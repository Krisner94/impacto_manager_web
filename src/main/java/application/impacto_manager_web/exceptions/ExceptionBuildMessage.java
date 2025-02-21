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

    public static Error errorBuildMessage(Long id) {
        return Error.builder()
            .title("Id não encontrado")
            .message("Não existe objeto no sistema com id " + id)
            .httpStatus(String.valueOf(HttpStatus.NOT_FOUND.value()))
            .build();
    }
}
