package repository;

import domain.Assinatura;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArquivoRepository {
    private static final String CAMINHO_ARQUIVO = "assinaturas.txt";

    public void salvarAssinatura(Assinatura assinatura) {
        try (FileWriter fw = new FileWriter(CAMINHO_ARQUIVO, true);
             PrintWriter pw = new PrintWriter(fw)) {
            // Salva no formato CSV simulado (separado por ponto e vírgula)
            pw.println(assinatura.toString());
            System.out.println("[Sistema] Dados persistidos com sucesso em " + CAMINHO_ARQUIVO);
        } catch (IOException e) {
            System.err.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }
}
