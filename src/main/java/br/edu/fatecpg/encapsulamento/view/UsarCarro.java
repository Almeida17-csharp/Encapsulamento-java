package br.edu.fatecpg.encapsulamento.view;

import br.edu.fatecpg.encapsulamento.model.Carro;
import java.util.ArrayList;
import java.util.Scanner;

public class UsarCarro {
    private static ArrayList<Carro> Carros = new ArrayList<>();

    public static void executar() {
        Scanner scan = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("\n--- GERENCIAMENTO DE CARROS ---");
            System.out.println("1 - Adicionar e Testar Novo Carro");
            System.out.println("2 - Remover Carro");
            System.out.println("3 - Listar Carros na Garagem");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    adicionarCarro(scan);
                    break;
                case 2:
                    removerCarro(scan);
                    break;
                case 3:
                    listarCarros();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void adicionarCarro(Scanner scan) {
        System.out.println("\n--- CADASTRANDO NOVO CARRO ---");
        System.out.print("Digite a marca do carro: ");
        String marca = scan.nextLine();

        System.out.print("Digite o modelo do carro: ");
        String modelo = scan.nextLine();

        System.out.print("Digite a placa do carro: ");
        String placa = scan.nextLine();

        System.out.print("Digite a capacidade do tanque (em Litros): ");
        int capacidade = scan.nextInt();
        scan.nextLine();

        Carro c1 = new Carro(marca, modelo, placa, capacidade);
        Carros.add(c1);

        System.out.println("Carro salvo na garagem! Total de carros: " + Carros.size());
        System.out.println("\n===============================\n");

        System.out.print("Você deseja encher o tanque? (y/n) ");
        String encher = scan.nextLine();

        if (encher.equalsIgnoreCase("y")){
            System.out.print("Qual o valor da gasolina no posto (por Litro)? ");
            double valorGas = scan.nextDouble();
            scan.nextLine();

            System.out.println(c1.encherTanque(valorGas));
        }

        System.out.println("\n===============================\n");

        System.out.print("Você deseja ligar o carro agora? (y/n) ");
        String ligar = scan.nextLine();

        if (ligar.equalsIgnoreCase("y")){
            System.out.println(c1.ligar());
        } else {
            System.out.println(c1.desligar());
        }

        System.out.print("Qual velocidade você está dirigindo? ");
        int velocidade = scan.nextInt();

        System.out.print("Qual a distância que você quer percorrer? ");
        double distancia = scan.nextDouble();
        scan.nextLine();

        System.out.println(c1.acelerar(velocidade, distancia));
    }

    private static void removerCarro(Scanner scan) {
        if (Carros.isEmpty()) {
            System.out.println("\nNão há carros na garagem para remover!");
            return;
        }

        listarCarros();
        System.out.print("\nDigite o número do carro que deseja remover (ou 0 para cancelar): ");
        int index = scan.nextInt();
        scan.nextLine();

        if (index == 0) {
            System.out.println("Remoção cancelada.");
        } else if (index > 0 && index <= Carros.size()) {
            Carro removido = Carros.remove(index - 1);
            System.out.println("Carro " + removido.getMarca() + " " + removido.getModelo() + " removido com sucesso!");
        } else {
            System.out.println("Número inválido! Nenhum carro foi removido.");
        }
    }

    private static void listarCarros() {
        if (Carros.isEmpty()) {
            System.out.println("\nA garagem está vazia no momento.");
        } else {
            System.out.println("\n--- CARROS NA GARAGEM ---");
            for (int i = 0; i < Carros.size(); i++) {
                Carro c = Carros.get(i);
                System.out.println((i + 1) + ". " + c.getMarca() + " " + c.getModelo() + " - Placa: " + c.getPlaca());
            }
        }
    }
}