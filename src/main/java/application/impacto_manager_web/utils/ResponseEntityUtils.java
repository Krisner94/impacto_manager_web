package application.impacto_manager_web.utils;

import org.springframework.http.ResponseEntity;

public class ResponseEntityUtils {
    public static <T> ResponseEntity<T> objectResponseEntity(T clazz){
        if(clazz == null){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(clazz);
    }
}
