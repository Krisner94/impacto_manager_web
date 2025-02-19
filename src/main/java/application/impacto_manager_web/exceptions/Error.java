package application.impacto_manager_web.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error {
    private String title;
    private String message;
    private String httpStatus;

}
