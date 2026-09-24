package br.edu.fatecpg.encapsulamento.model;

public class Carro {
    private String marca;
    private String modelo;
    private String placa;
    private int capacidadeGasolina;

    public Carro(String mrc, String mod, String plc, int cpcdGas) {
        this.marca = mrc;
        this.modelo = mod;
        this.placa = plc;
        this.capacidadeGasolina = cpcdGas;
    }

    public String getMarca() {return this.marca;}
    public void setMarca(String marca) {this.marca = marca;}
    public String getModelo() {return this.modelo;}
    public void setModelo(String modelo) {this.modelo = modelo;}
    public String getPlaca() {return this.placa;}
    public void setPlaca(String placa) {this.placa = placa;}
    public int getCapacidadeGasolina() {return this.capacidadeGasolina;}
    public void setCapacidadeGasolina(int cpcdGas) {this.capacidadeGasolina = cpcdGas;}

    public String ligar() {
        return "Carro Ligado!";
    }
    public String desligar() {
        return "Carro Desligado!";
    }

    public String buzinar() {
        return "Bi Bi Bi";
    }

    public String acelerar(int velocidade, double distancia) {
        double tempoHoras = distancia / velocidade;
        double tempoMinutos = tempoHoras * 60;

        return String.format("Você acelerou a %d km/h por %.1f km. O trajeto levou %.1f minutos (%.2f horas).",
                velocidade, distancia, tempoMinutos, tempoHoras);
    }

    public String encherTanque(Double precoGas, int qtdGas) {
        double valorTotal;
        valorTotal = precoGas * qtdGas;
        return String.format("Valor a pagar: R$ %.2f", valorTotal);
    }
}
