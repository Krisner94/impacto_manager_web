package application.impacto_manager_web.utils;

import application.impacto_manager_web.exceptions.CustomException;
import application.impacto_manager_web.model.Turma;
import application.impacto_manager_web.model.TurmaGenerated;
import application.impacto_manager_web.repository.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static application.impacto_manager_web.exceptions.ExceptionBuildMessage.errorBuildMessage;

@Slf4j
public class ResponseEntityUtils {
    /**
     * Exclui uma entidade pelo ID.
     *
     * @param repository Instância do repositório.
     * @param id         ID da entidade a ser excluída.
     * @param <T>        Tipo da entidade.
     * @param clazz      Classe da entidade/model.
     * @return Resposta HTTP 204 (No Content).
     */
    public static <T> ResponseEntity<Void> delete(JpaRepository<T, Long> repository, Class<?> clazz, Long id) {
        if (!repository.existsById(id)) {
            throw new CustomException()
                .addError(errorBuildMessage(clazz, id));
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Retorna uma resposta HTTP 200 (OK) com o objeto fornecido.
     *
     * @param object Objeto a ser retornado.
     * @param <T>    Tipo do objeto.
     * @return Resposta HTTP 200 (OK).
     */
    public static <T> ResponseEntity<T> ok(T object) {
        if (object == null) {
            throw new IllegalArgumentException("Objeto não pode ser nulo.");
        }
        return ResponseEntity.ok(object);
    }

    /**
     * Retorna uma resposta HTTP 200 (OK) após validar a existência da entidade.
     *
//     * @param repository Instância do repositório.
     * @param body     Entidade a ser validada.
     * @param <T>        Tipo da entidade.
     * @return Resposta HTTP 200 (OK).
     */
    public static <T> ResponseEntity<T> ok(T body, Long id) {
        if (body == null) {
            throw new IllegalArgumentException("Entidade não pode ser nula.");
        }
        try{
            body.getClass().getMethod("getId").invoke(body);
        } catch (RuntimeException | NoSuchMethodException e) {
            throw new CustomException()
                .addError(errorBuildMessage(body.getClass(), id));
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(body);
    }

    /**
     * Retorna uma resposta HTTP 201 (Created) com o objeto fornecido.
     *
     * @param mapper         Objeto mapper (DTO) a ser retornado.
     * @param objectToCreate Objeto que será criado (entidade).
     * @param repository     Repositório da entidade.
     * @return Resposta HTTP 201 (Created) com o mapper no corpo.
     */
    public static <T, U> ResponseEntity<T> created(T mapper, U objectToCreate, JpaRepository<U, Long> repository) {
        if (mapper == null || objectToCreate == null) {
            throw new IllegalArgumentException("Objetos não podem ser nulos.");
        }
        repository.save(objectToCreate);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapper);
    }
}