import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo ao Banco SPI!!\n");
        while (true) {
            System.out.println("Qual o tipo da sua conta?");
            System.out.println("1. Conta Corrente");
            System.out.println("2. Conta Poupança");
            System.out.println("3. Sair\n");

            System.out.print("Digite o número de sua opção: ");
            int escolhaConta = scanner.nextInt();

            TipoDeConta contaSelecionada;

            if (escolhaConta == 1) {
                contaSelecionada = new ContaCorrente();
                System.out.println("\nConta Corrente selecionada.");
            } else if (escolhaConta == 2) {
                contaSelecionada = new ContaPoupanca();
                System.out.println("\nConta Poupança selecionada.");
            } else if (escolhaConta == 3) {
                System.out.println("\nO Banco SPI agradece por utilizar o nosso serviço!!");
                System.out.println("Tenha um ótimo dia e volte sempre.");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            operacoesConta(contaSelecionada, scanner);
        }

        scanner.close();
    }

    public static void operacoesConta(TipoDeConta conta, Scanner scanner) {
        while (true) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Verificar Saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Voltar");
            System.out.println("5. Sair");

            System.out.print("\nDigite o número de sua opção: ");
            int escolhaOperacao = scanner.nextInt();

            switch (escolhaOperacao) {
                case 1:
                    System.out.println("\n======================================================");
                    System.out.printf("                Saldo atual: R$ %.2f.\n",  conta.saldo);
                    System.out.println("======================================================");
                    break;
                case 2:
                    if (conta instanceof ContaCorrente) {
                        System.out.print("\nInforme o valor do depósito: R$ ");
                        double valorDeposito = scanner.nextDouble();
                        ((ContaCorrente) conta).depositar(valorDeposito);
                    } else if (conta instanceof ContaPoupanca) {
                        System.out.print("\nInforme o valor do depósito: R$ ");
                        double valorDeposito = scanner.nextDouble();
                        ((ContaPoupanca) conta).depositar(valorDeposito);
                    }
                    System.out.println("\n======================================================");
                    System.out.printf("                Saldo atual: R$ %.2f.", conta.saldo);
                    System.out.println("\n======================================================");
                    break;
                case 3:
                    if (conta instanceof ContaCorrente) {
                        System.out.print("\nInforme o valor do saque: R$ ");
                        double valorSaque = scanner.nextDouble();
                        ((ContaCorrente) conta).sacar(valorSaque);
                    } else if (conta instanceof ContaPoupanca) {
                        System.out.print("\nInforme o valor do saque: R$ ");
                        double valorSaque = scanner.nextDouble();
                        ((ContaPoupanca) conta).sacar(valorSaque);
                    }
                    System.out.println("\n======================================================");
                    System.out.printf("                Saldo atual: R$ %.2f.", conta.saldo);
                    System.out.println("\n======================================================\n");
                    break;
                case 4:
                    System.out.println("\nVoltando para o menu inicial.\n");
                    return;
                case 5:
                    System.out.println("\nO Banco SPI agradece por utilizar o nosso serviço!!");
                    System.out.println("Tenha um ótimo dia e volte sempre.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}