package br.edu.fatecpg.encapsulamento.view;

import br.edu.fatecpg.encapsulamento.model.ContaBancaria;
import java.util.Scanner;

public class UsarContaBancaria {

    public static void executar() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n--- ABRINDO CONTA BANCÁRIA ---");
        System.out.print("Digite o nome do titular da conta: ");
        String titular = scan.nextLine();

        System.out.print("Digite o saldo inicial de abertura: R$ ");
        double saldoInicial = scan.nextDouble();
        scan.nextLine();

        ContaBancaria conta = new ContaBancaria(titular, saldoInicial);
        System.out.println("Conta criada com sucesso para " + conta.getTitular() + " com saldo de R$ " + conta.getSaldo());

        int opcao = -1;
        do {
            System.out.println("\n--- CAIXA ELETRÔNICO ---");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Ver Saldo");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma operação: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Qual valor deseja depositar? R$ ");
                    double valorDep = scan.nextDouble();
                    scan.nextLine();
                    conta.depositar(valorDep);
                    break;
                case 2:
                    System.out.print("Qual valor deseja sacar? R$ ");
                    double valorSaque = scan.nextDouble();
                    scan.nextLine();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    System.out.println("Saldo atual de " + conta.getTitular() + ": R$ " + conta.getSaldo());
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
}