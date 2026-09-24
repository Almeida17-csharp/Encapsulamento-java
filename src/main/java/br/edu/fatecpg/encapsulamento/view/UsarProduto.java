package br.edu.fatecpg.encapsulamento.view;

import br.edu.fatecpg.encapsulamento.model.Produto;
import java.util.ArrayList;
import java.util.Scanner;

public class UsarProduto {

    // Lista para gerenciar o estoque de vários produtos
    private static ArrayList<Produto> estoque = new ArrayList<>();

    public static void executar() {
        Scanner scan = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("\n--- GERENCIAMENTO DE ESTOQUE ---");
            System.out.println("1 - Cadastrar Novo Produto");
            System.out.println("2 - Atualizar Preço");
            System.out.println("3 - Atualizar Quantidade em Estoque");
            System.out.println("4 - Listar Produtos");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProduto(scan);
                    break;
                case 2:
                    atualizarPreco(scan);
                    break;
                case 3:
                    atualizarEstoque(scan);
                    break;
                case 4:
                    listarProdutos();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarProduto(Scanner scan) {
        System.out.println("\n--- CADASTRO DE PRODUTO ---");
        System.out.print("Digite o nome do produto: ");
        String nome = scan.nextLine();

        System.out.print("Digite o preço do produto: R$ ");
        double preco = scan.nextDouble();

        System.out.print("Digite a quantidade inicial em estoque: ");
        int qtd = scan.nextInt();
        scan.nextLine();

        Produto novoProduto = new Produto(nome, preco, qtd);
        estoque.add(novoProduto);
        System.out.println("Produto '" + novoProduto.getNome() + "' adicionado ao sistema!");
    }

    private static void atualizarPreco(Scanner scan) {
        if (estoque.isEmpty()) {
            System.out.println("\nNão há produtos cadastrados.");
            return;
        }

        listarProdutos();
        System.out.print("\nDigite o número do produto que deseja alterar o preço: ");
        int index = scan.nextInt();
        scan.nextLine();

        if (index > 0 && index <= estoque.size()) {
            Produto p = estoque.get(index - 1);
            System.out.print("Digite o novo preço para '" + p.getNome() + "': R$ ");
            double novoPreco = scan.nextDouble();
            scan.nextLine();

            p.setPreco(novoPreco);
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void atualizarEstoque(Scanner scan) {
        if (estoque.isEmpty()) {
            System.out.println("\nNão há produtos cadastrados.");
            return;
        }

        listarProdutos();
        System.out.print("\nDigite o número do produto que deseja alterar o estoque: ");
        int index = scan.nextInt();
        scan.nextLine();

        if (index > 0 && index <= estoque.size()) {
            Produto p = estoque.get(index - 1);
            System.out.print("Digite a nova quantidade em estoque para '" + p.getNome() + "': ");
            int novaQtd = scan.nextInt();
            scan.nextLine();

            p.setQuantidadeEstoque(novaQtd);
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void listarProdutos() {
        if (estoque.isEmpty()) {
            System.out.println("\nO estoque está vazio.");
        } else {
            System.out.println("\n--- LISTA DE PRODUTOS ---");
            for (int i = 0; i < estoque.size(); i++) {
                Produto p = estoque.get(i);
                System.out.println((i + 1) + ". " + p.getNome() + " | Preço: R$ " + p.getPreco() + " | Estoque: " + p.getQuantidadeEstoque() + " unidades");
            }
        }
    }
}