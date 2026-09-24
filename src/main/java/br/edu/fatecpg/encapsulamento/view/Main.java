package br.edu.fatecpg.encapsulamento.view;

import java.util.Scanner;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcao = -1;
        String saudacao = saudacao();

        do {
            System.out.println("\nOlá, " + saudacao + "! Gostaria de ver o que?\n"
                    + "1 - Carros\n"
                    + "2 - Conta Bancária\n"
                    + "3 - Produtos\n"
                    + "0 - Sair");
            System.out.print("Digite uma opção: ");

            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Você está vendo os carros!");
                    UsarCarro.executar();
                    break;
                case 2:
                    System.out.println("Você está vendo as contas!");
                    UsarContaBancaria.executar();
                    break;
                case 3:
                    System.out.println("Funcionalidade de Produtos em desenvolvimento...");
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while(opcao != 0);

        scan.close();
    }

    static String saudacao() {
        LocalTime agora = LocalTime.now();
        int hora = agora.getHour();
        String periodo;

        if (hora >= 5 && hora < 12) {
            periodo = "Bom dia";
        } else if (hora >= 12 && hora < 18) {
            periodo = "Boa tarde";
        } else {
            periodo = "Boa noite";
        }

        return periodo + " Senhor(a)";
    }
}