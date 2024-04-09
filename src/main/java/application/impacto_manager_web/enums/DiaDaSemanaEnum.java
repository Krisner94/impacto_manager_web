package application.impacto_manager_web.enums;

public enum DiaDaSemanaEnum {
    SEGUNDA("segunda"),
    TERCA("terça"),
    QUARTA("quarta"),
    QUINTA("quinta"),
    SEXTA("sexta"),
    SABADO("sábado"),
    DOMINGO("domingo");

    private String dia;

    DiaDaSemanaEnum(String dia) {
        this.dia = dia;
    }

    public String getDia() {
        return this.dia;
    }
}
