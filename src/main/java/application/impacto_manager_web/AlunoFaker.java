package application.impacto_manager_web;

import application.impacto_manager_web.enums.SexoEnum;
import application.impacto_manager_web.model.Aluno;
import application.impacto_manager_web.repository.AlunoRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Component
@AllArgsConstructor
public class AlunoFaker extends Faker {
    private AlunoRepository alunoRepository;

    public void insertFakeAlunosIntoDatabase(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            Aluno alunoFake = fakeAluno();
            alunoRepository.save(alunoFake);
        }
    }

    public Aluno fakeAluno() {
        Faker faker = new Faker(new Locale("pt-BR"));

        Date birthday = faker.date().birthday();
        String dataNascimento = new SimpleDateFormat("yyyy-MM-dd").format(birthday);

        String sexoString = faker.demographic().sex();
        SexoEnum sexo = sexoString.equals("Male") ? SexoEnum.MASCULINO : SexoEnum.FEMININO;
        String cpf = faker.number().digits(11).replaceAll("\\D", "").substring(0, 11);

        Aluno alunoFake = Aluno.builder()
                .id(null)
                .nome(faker.name().fullName())
                .cpf(cpf)
                .dataNascimento(LocalDate.parse(dataNascimento))
                .telefone(faker.phoneNumber().cellPhone().replaceAll("\\D", "").substring(0, 11))
                .cep(faker.address().zipCode())
                .rua(faker.address().streetAddress())
                .cidade(faker.address().cityName())
                .numeroCasa(faker.address().streetAddressNumber())
                .responsavel01(faker.funnyName().name())
                .responsavel02(faker.funnyName().name())
                .telefoneResponsavel01(faker.phoneNumber().cellPhone().replaceAll("\\D", "").substring(0, 11))
                .telefoneResponsavel02(faker.phoneNumber().cellPhone().replaceAll("\\D", "").substring(0, 11))
                .sexo(sexo) // seta o sexo do aluno fake
                .build();

        return alunoFake;
    }
}