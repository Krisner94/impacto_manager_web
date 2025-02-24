package application.impacto_manager_web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Error> handleCustomException(CustomException ex) {
        return ex.getErrors().getFirst().getHttpStatus().equals(String.valueOf(HttpStatus.NOT_FOUND.value())) ?
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getErrors().getFirst()) :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors().getFirst());
    }
}