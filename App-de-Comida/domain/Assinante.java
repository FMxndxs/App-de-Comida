package domain;

public class Assinante {
    private String celular;

    public Assinante(String celular) {
        this.celular = celular;
    }

    public String getCelular() {
        return celular;
    }

    public void adicionarEndereco(Endereco end) {
        // Simula adição de endereço à lista do assinante
    }
}
