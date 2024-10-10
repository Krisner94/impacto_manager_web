package application.impacto_manager_web.exceptions;

public class NotFoundException extends ResourceNotFoundException {
    public NotFoundException(Class<?> clazz, Long id) {
        super(String.format("%s with ID %d not found", clazz.getSimpleName(), id));
    }
}