package application.impacto_manager_web.enums;

public enum SexoEnum {
    MASCULINO("masculino"),
    FEMININO("feminino");

    private String sexo;

    private SexoEnum(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
