package application.impacto_manager_web.model.base;

import application.impacto_manager_web.enums.SexoEnum;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Pessoa {
    private String nome;
    private String cpf;
    private SexoEnum sexo;
}
