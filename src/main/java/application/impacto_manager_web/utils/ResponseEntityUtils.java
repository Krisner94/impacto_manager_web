package application.impacto_manager_web.utils;

import application.impacto_manager_web.model.ProfessorGenerated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityUtils {
    public static <T> ResponseEntity<T> responseEntity(T clazz){
        if(clazz == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(clazz);
    }

    public static ResponseEntity<Void> noContent(){
        return ResponseEntity.noContent().build();
    }

    public static <T> ResponseEntity<T> ok(){
        return ResponseEntity.ok().build();
    }
}
