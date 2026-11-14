package domain;

public class PlanoAssinatura {
    private String nome;
    private int quantidadeRefeicoes;
    private double valor;

    public PlanoAssinatura(String nome, int qtde, double valor) {
        this.nome = nome;
        this.quantidadeRefeicoes = qtde;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}
