package boundary;

import controller.AssinaturaController;
import domain.Assinatura;
import java.util.Scanner;

public class AppView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AssinaturaController controller = new AssinaturaController();

        System.out.println("=== BEM-VINDO AO MINHA REFEICAO ===");
        
        System.out.print("Informe seu celular: ");
        String celular = scanner.nextLine();
        controller.iniciarAutenticacao(celular);
        
        System.out.print("Informe o codigo SMS recebido (digite 1234): ");
        String codigo = scanner.nextLine();
        
        if (controller.validarCodigo(codigo)) {
            System.out.println("Autenticado com sucesso!");
            
            System.out.println("\nPlanos disponiveis: [1] Basico - R$129.90 | [2] Premium - R$389.90");
            System.out.print("Escolha o plano: ");
            int plano = scanner.nextInt();
            controller.setPlanoEscolhido(plano);
            scanner.nextLine(); // Limpar buffer
            
            System.out.print("\nCEP de Entrega: ");
            String cep = scanner.nextLine();
            controller.registrarEndereco(cep, "Rua Exemplo", "123");
            
            System.out.print("\nNumero do Cartao de Credito: ");
            String cartao = scanner.nextLine();
            
            System.out.println("\nProcessando Pagamento...");
            Assinatura assinatura = controller.processarAssinatura(cartao);
            
            if (assinatura.getStatus().equals("Ativa")) {
                System.out.println("\n=== SUCESSO! ASSINATURA ATIVA ===");
                System.out.println("Protocolo: " + assinatura.getProtocolo());
            } else {
                System.out.println("\n[FALHA] Transacao nao autorizada pela operadora. Status: " + assinatura.getStatus());
            }
            
        } else {
            System.out.println("Falha na autenticacao.");
        }
        scanner.close();
    }
}
