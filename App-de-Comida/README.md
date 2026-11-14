# App de Comida - Plataforma Minha Refeição (Implementação Java)

Este repositório contém a implementação prática (Entrega 4) do modelo dinâmico do sistema de assinatura de marmitas "Minha Refeição", desenvolvido para a disciplina de Projeto de Software do Mackenzie.

## Equipe
* Felipe Mendes Campos - RA 10740655
* Eric Kanomata Schutz Cabrera - RA 10736688
* Pedro Henrique Sanchez de Souza - RA 10737795

## Arquitetura do Projeto
O código foi estruturado em pacotes garantindo a separação de responsabilidades (MVC/Boundary-Control-Entity):
* `boundary`: Contém a classe `AppView` responsável pela interação com o usuário (Interface).
* `controller`: Contém a classe `AssinaturaController` que orquestra as regras de negócio mapeadas no Diagrama de Sequência.
* `domain`: Contém as entidades (Assinatura, Assinante, PlanoAssinatura, etc.) mapeadas no Diagrama de Classes.
* `repository`: Contém a classe `ArquivoRepository`, responsável pela persistência dos dados em arquivo TXT.

## Orientações para Execução

### 1. Pré-requisitos
* Ter o **Java JDK 11** (ou superior) instalado na máquina.
* Uma IDE de sua preferência (Eclipse, IntelliJ IDEA, VS Code) ou utilizar via linha de comando (Terminal/CMD).

### 2. Como Rodar e Testar o Código via IDE (Recomendado)
1. Faça o clone deste repositório: `git clone https://github.com/FMxndxs/App-de-Comida.git`
2. Abra a sua IDE e selecione **Open Project** ou **Import Project**.
3. Selecione a pasta raiz `App-de-Comida`.
4. No explorador de arquivos da IDE, navegue até o pacote `boundary` e abra o arquivo `AppView.java`.
5. Execute a classe (botão de **Run** ou play verde).
6. O console abrirá aguardando a interação do usuário.

### 3. Como Rodar e Testar via Linha de Comando (Terminal / CMD)
1. Faça o clone do repositório e navegue até a raiz do projeto:
   ```bash
   cd caminho/para/App-de-Comida
   ```
2. Compile todos os arquivos Java simultaneamente com o comando:
   ```bash
   javac boundary/*.java controller/*.java domain/*.java repository/*.java
   ```
3. Execute a classe principal (AppView) com o comando:
   ```bash
   java boundary.AppView
   ```

### 4. Validação do Caminho Feliz e Persistência
Assim que o programa rodar, interaja com o console inserindo as seguintes informações para simular o fluxo principal:
* **Celular:** Digite qualquer número (ex: `11999999999`).
* **Código SMS:** Digite obrigatoriamente **`1234`** e pressione Enter para validar a autenticação.
* **Plano:** Digite `1` ou `2` para selecionar.
* **CEP:** Insira qualquer valor numérico.
* **Cartão de Crédito:** Insira dados fictícios.

Ao finalizar o fluxo com sucesso, o console exibirá a ativação da assinatura. 
Para validar o critério de **persistência de dados**, abra a raiz do projeto e verifique a criação do arquivo **`assinaturas.txt`**, que conterá a nova assinatura registrada.
