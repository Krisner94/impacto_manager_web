package application.impacto_manager_web.CEP;

public class BuscaCep {
    public static void main(String[] args) {
        Endereco endereco = CEP_Service.buscaEndereco("32605316");
        System.out.println(endereco.getLocalidade());
        System.out.println(endereco.getBairro());
        System.out.println(endereco.getLogradouro());
    }
}
