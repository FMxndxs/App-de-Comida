package domain;

public class Assinatura {
    private String protocolo;
    private String status;
    private String previsaoEntrega;
    private Assinante assinante;
    private PlanoAssinatura plano;
    private double valorTotal;

    public Assinatura(Assinante assinante, PlanoAssinatura plano, double valorTotal) {
        this.assinante = assinante;
        this.plano = plano;
        this.valorTotal = valorTotal;
        this.status = "Aguardando Pagamento";
    }

    public void setStatus(String status) { this.status = status; }
    public String getStatus() { return status; }
    
    public void calcularPrevisaoEntrega() { this.previsaoEntrega = "Proxima Segunda-feira"; }
    public void gerarProtocolo() { this.protocolo = "MR-" + System.currentTimeMillis(); }
    
    public String getProtocolo() { return protocolo; }
    
    @Override
    public String toString() {
        return protocolo + ";" + assinante.getCelular() + ";" + plano.getNome() + ";" + status + ";" + valorTotal;
    }
}
