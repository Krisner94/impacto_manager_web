package application.impacto_manager_web.enums;

public enum DiaDaSemanaEnum {
    SEGUNDA(1, "segunda"),
    TERCA(2, "terça"),
    QUARTA(3, "quarta"),
    QUINTA(4, "quinta"),
    SEXTA(5, "sexta"),
    SABADO(6, "sábado"),
    DOMINGO(7, "domingo");

    private String dia;

    private Integer cod;

    DiaDaSemanaEnum(Integer cod, String dia) {
        this.dia = dia;
        this.cod = cod;
    }

    public Integer getCod() {
        return this.cod;
    }

    public String getDia() {
        return this.dia;
    }
    public static DiaDaSemanaEnum toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (DiaDaSemanaEnum x : DiaDaSemanaEnum.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

}
