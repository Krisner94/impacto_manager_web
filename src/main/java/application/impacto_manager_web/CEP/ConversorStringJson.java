package application.impacto_manager_web.CEP;

import java.io.BufferedReader;
import java.io.IOException;

public class ConversorStringJson {
    public static String converteJsonEmString(BufferedReader buffereReader) throws IOException, IOException, IOException {
        String resposta;
        StringBuilder jsonEmString = new StringBuilder();
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString.append(resposta);
        }
        return jsonEmString.toString();
    }
}
