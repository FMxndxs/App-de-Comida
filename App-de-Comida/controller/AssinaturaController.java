package controller;

import domain.*;
import repository.ArquivoRepository;

public class AssinaturaController {
    private Assinante assinanteAtual;
    private PlanoAssinatura planoEscolhido;
    private Assinatura assinaturaAtual;
    private ArquivoRepository repository = new ArquivoRepository();

    public boolean iniciarAutenticacao(String celular) {
        this.assinanteAtual = new Assinante(celular);
        // Simula envio de SMS
        return true; 
    }

    public boolean validarCodigo(String codigo) {
        return codigo.equals("1234"); // Código fixo para demonstração
    }

    public void setPlanoEscolhido(int idPlano) {
        if (idPlano == 1) this.planoEscolhido = new PlanoAssinatura("Plano Basico", 5, 129.90);
        else this.planoEscolhido = new PlanoAssinatura("Plano Premium", 20, 389.90);
    }

    public void registrarEndereco(String cep, String rua, String numero) {
        Endereco end = new Endereco(cep, rua, numero);
        this.assinanteAtual.adicionarEndereco(end);
    }

    public Assinatura processarAssinatura(String numCartao) {
        this.assinaturaAtual = new Assinatura(assinanteAtual, planoEscolhido, planoEscolhido.getValor());
        
        // Simula IOperadoraCartaoCredito: recusa se digitar "0000"
        boolean autorizado = !numCartao.trim().equals("0000"); 
        
        if (autorizado) {
            this.assinaturaAtual.setStatus("Ativa");
            this.assinaturaAtual.calcularPrevisaoEntrega();
            this.assinaturaAtual.gerarProtocolo();
            repository.salvarAssinatura(this.assinaturaAtual);
        } else {
            this.assinaturaAtual.setStatus("Pagamento Recusado");
        }
        return this.assinaturaAtual;
    }
}
