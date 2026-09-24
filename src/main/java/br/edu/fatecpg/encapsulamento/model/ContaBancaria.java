package br.edu.fatecpg.encapsulamento.model;

public class ContaBancaria {
    private Usuario titular;
    private double saldo;

    public ContaBancaria(Usuario titular, double saldoInicial) {
        this.titular = titular;
        if (saldoInicial > 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0;
        }
    }

    public Usuario getTitular() {
        return titular;
    }

    public void setTitular(Usuario titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Erro: O valor de depósito deve ser positivo.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else if (valor > this.saldo) {
            System.out.println("Erro: Saldo insuficiente. Saldo atual: R$ " + this.saldo);
        } else {
            System.out.println("Erro: O valor de saque deve ser positivo.");
        }
    }

    public void transferir(double valor, ContaBancaria contaDestino) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("Transferência de R$ " + valor + " para " + contaDestino.getTitular().getNome() + " realizada com sucesso!");
        } else if (valor > this.saldo) {
            System.out.println("Erro: Saldo insuficiente para transferência. Saldo atual: R$ " + this.saldo);
        } else {
            System.out.println("Erro: O valor da transferência deve ser positivo.");
        }
    }
}