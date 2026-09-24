package br.edu.fatecpg.encapsulamento.model;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        // Chamando os setters no construtor para aproveitar as regras de validação desde o início
        setPreco(preco);
        setQuantidadeEstoque(quantidadeEstoque);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
            System.out.println("Preço atualizado com sucesso!");
        } else {
            System.out.println("Erro: O preço não pode ser um valor negativo. Operação cancelada.");
        }
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque >= 0) {
            this.quantidadeEstoque = quantidadeEstoque;
            System.out.println("Estoque atualizado com sucesso!");
        } else {
            System.out.println("Erro: A quantidade em estoque não pode ser menor que zero. Operação cancelada.");
        }
    }
}