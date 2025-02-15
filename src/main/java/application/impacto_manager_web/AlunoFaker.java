//package application.impacto_manager_web;
//
//import application.impacto_manager_web.enums.SexoEnum;
//import application.impacto_manager_web.model.Aluno;
//import application.impacto_manager_web.repository.AlunoRepository;
//import com.github.javafaker.Faker;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Locale;
//
//@Component
//@AllArgsConstructor
//public class AlunoFaker {
//    private final AlunoRepository alunoRepository;
//    private final Faker faker = new Faker(new Locale("pt-BR"));
//
//    public void insertFakeAlunosIntoDatabase(int quantidade) {
//        for (int i = 0; i < quantidade; i++) {
//            try {
//                Aluno alunoFake = fakeAluno();
//                alunoRepository.save(alunoFake);
//            } catch (Exception e) {
//                System.err.println("Erro ao salvar aluno fake: " + e.getMessage());
//            }
//        }
//    }
//
//    public Aluno fakeAluno() {
//        LocalDate dataNascimento = faker.date().birthday().toInstant()
//                .atZone(java.time.ZoneId.systemDefault())
//                .toLocalDate();
//
//        String sexoString = faker.demographic().sex();
//        SexoEnum sexo = sexoString.equalsIgnoreCase("Male") ? SexoEnum.MASCULINO : SexoEnum.FEMININO;
//
//        String cpf = faker.number().digits(11);
//
//        return Aluno.builder()
//                .id(null)
//                .dataNascimento(dataNascimento)
//                .telefone(faker.phoneNumber().cellPhone().replaceAll("\\D", "").substring(0, 11))
//                .cep(faker.address().zipCode())
//                .rua(faker.address().streetAddress())
//                .cidade(faker.address().cityName())
//                .numeroCasa(faker.address().streetAddressNumber())
//                .responsavel01(faker.funnyName().name())
//                .responsavel02(faker.funnyName().name())
//                .telefoneResponsavel01(faker.phoneNumber().cellPhone().replaceAll("\\D", "").substring(0, 11))
//                .telefoneResponsavel02(faker.phoneNumber().cellPhone().replaceAll("\\D", "").substring(0, 11))
//                .nome(faker.name().fullName()) // Define o nome diretamente no Builder
//                .cpf(cpf)
//                .sexo(sexo)
//                .build();
//    }
//}