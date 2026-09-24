package br.edu.fatecpg.encapsulamento.view;

import br.edu.fatecpg.encapsulamento.model.ContaBancaria;
import br.edu.fatecpg.encapsulamento.model.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

public class UsarContaBancaria {

    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<ContaBancaria> contas = new ArrayList<>();

    public static void executar() {
        Scanner scan = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("\n--- SISTEMA BANCÁRIO ---");
            System.out.println("1 - Cadastrar Novo Usuário");
            System.out.println("2 - Abrir Nova Conta");
            System.out.println("3 - Acessar Caixa Eletrônico (Operações)");
            System.out.println("4 - Listar Usuários e Contas");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarUsuario(scan);
                    break;
                case 2:
                    abrirConta(scan);
                    break;
                case 3:
                    acessarCaixa(scan);
                    break;
                case 4:
                    listarUsuariosEContas();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void cadastrarUsuario(Scanner scan) {
        System.out.println("\n--- CADASTRO DE USUÁRIO ---");
        System.out.print("Digite o nome do usuário: ");
        String nome = scan.nextLine();

        System.out.print("Digite o CPF do usuário: ");
        String cpf = scan.nextLine();

        Usuario novoUsuario = new Usuario(nome, cpf);
        usuarios.add(novoUsuario);
        System.out.println("Usuário " + novoUsuario.getNome() + " cadastrado com sucesso!");
    }

    private static void abrirConta(Scanner scan) {
        if (usuarios.isEmpty()) {
            System.out.println("\nÉ necessário cadastrar um usuário antes de abrir uma conta.");
            return;
        }

        System.out.println("\n--- ABERTURA DE CONTA ---");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i + 1) + ". Nome: " + usuarios.get(i).getNome() + " | CPF: " + usuarios.get(i).getCpf());
        }

        System.out.print("Selecione o número do usuário para vincular à conta: ");
        int idUsuario = scan.nextInt();
        scan.nextLine();

        if (idUsuario > 0 && idUsuario <= usuarios.size()) {
            Usuario titularSelecionado = usuarios.get(idUsuario - 1);

            System.out.print("Digite o depósito inicial de abertura: R$ ");
            double saldoInicial = scan.nextDouble();
            scan.nextLine();

            ContaBancaria novaConta = new ContaBancaria(titularSelecionado, saldoInicial);
            contas.add(novaConta);
            System.out.println("Conta criada com sucesso para " + novaConta.getTitular().getNome() + "!");
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }

    private static void acessarCaixa(Scanner scan) {
        if (contas.isEmpty()) {
            System.out.println("\nNão há contas cadastradas no sistema!");
            return;
        }

        System.out.println("\n--- CONTAS ATIVAS ---");
        for (int i = 0; i < contas.size(); i++) {
            System.out.println((i + 1) + ". Titular: " + contas.get(i).getTitular().getNome());
        }

        System.out.print("\nDigite o número da sua conta para acessar: ");
        int index = scan.nextInt();
        scan.nextLine();

        if (index > 0 && index <= contas.size()) {
            ContaBancaria contaAtual = contas.get(index - 1);
            menuOperacoes(scan, contaAtual);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private static void menuOperacoes(Scanner scan, ContaBancaria conta) {
        int opcao = -1;
        do {
            System.out.println("\n--- CAIXA ELETRÔNICO | Titular: " + conta.getTitular().getNome() + " | Saldo Atual: R$ " + conta.getSaldo() + " ---");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("0 - Sair da Conta");
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
                    if (contas.size() < 2) {
                        System.out.println("É necessário ter pelo menos outra pessoa cadastrada com conta no sistema para transferir.");
                        break;
                    }
                    System.out.println("\n--- SELECIONE QUEM VAI RECEBER A TRANSFERÊNCIA ---");
                    for (int i = 0; i < contas.size(); i++) {
                        if (contas.get(i) != conta) {
                            System.out.println((i + 1) + ". " + contas.get(i).getTitular().getNome());
                        }
                    }
                    System.out.print("Digite o número do destinatário: ");
                    int idDestino = scan.nextInt();
                    scan.nextLine();

                    if (idDestino > 0 && idDestino <= contas.size() && contas.get(idDestino - 1) != conta) {
                        System.out.print("Qual valor deseja transferir? R$ ");
                        double valorTransf = scan.nextDouble();
                        scan.nextLine();
                        conta.transferir(valorTransf, contas.get(idDestino - 1));
                    } else {
                        System.out.println("Destinatário inválido!");
                    }
                    break;
                case 0:
                    System.out.println("Saindo da conta de " + conta.getTitular().getNome() + "...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void listarUsuariosEContas() {
        if (usuarios.isEmpty()) {
            System.out.println("\nNenhum usuário cadastrado.");
        } else {
            System.out.println("\n--- USUÁRIOS CADASTRADOS ---");
            for (int i = 0; i < usuarios.size(); i++) {
                System.out.println((i + 1) + ". Nome: " + usuarios.get(i).getNome() + " | CPF: " + usuarios.get(i).getCpf());
            }
        }

        if (contas.isEmpty()) {
            System.out.println("\nNenhuma conta ativa no momento.");
        } else {
            System.out.println("\n--- CONTAS ATIVAS ---");
            for (int i = 0; i < contas.size(); i++) {
                System.out.println((i + 1) + ". Titular: " + contas.get(i).getTitular().getNome() + " | Saldo: R$ " + contas.get(i).getSaldo());
            }
        }
    }
}