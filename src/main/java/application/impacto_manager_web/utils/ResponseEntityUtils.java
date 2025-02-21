package application.impacto_manager_web.utils;

import application.impacto_manager_web.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static application.impacto_manager_web.exceptions.ExceptionBuildMessage.errorBuildMessage;

public class ResponseEntityUtils {
    public static <T> ResponseEntity<T> responseEntity(T clazz){
        if(clazz == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(clazz);
    }

    public static ResponseEntity<Void> noContent(Long id){
        try{
            return ResponseEntity.noContent().build();
        } catch (NullPointerException e){
            throw new CustomException().addError(errorBuildMessage(id));
        }
    }

    public static <T> ResponseEntity<T> ok(){
        return ResponseEntity.ok().build();
    }

    public static <T> ResponseEntity<T> ok(T object){
        return ResponseEntity.ok(object);
    }

    public static <T> ResponseEntity<T> created(T object){
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }
}
