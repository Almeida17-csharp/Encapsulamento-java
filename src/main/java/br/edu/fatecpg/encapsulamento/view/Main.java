package br.edu.fatecpg.encapsulamento.view;

import br.edu.fatecpg.encapsulamento.model.Carro;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Carro c1 = new Carro("", "", "", 0);
        LinkedList<Carro> carros = new LinkedList<>();
        Double valorGas, distancia;
        int velocidade;

        c1.setMarca("Renault");
        System.out.println("Marca: " + c1.getMarca());
        c1.setModelo("Sandero");
        System.out.println("Modelo: " + c1.getModelo());
        c1.setPlaca("EFG-4H56");
        System.out.println("Placa: " + c1.getPlaca());
        c1.setCapacidadeGasolina(55);
        System.out.println("Capacidade do tanque em Litros: " + c1.getCapacidadeGasolina());

        System.out.println("\n===============================\n");

        System.out.print("Olá, qual o valor da gasolina no posto (por Litro)? ");
        valorGas = scan.nextDouble();

        System.out.println(c1.encherTanque(valorGas, c1.getCapacidadeGasolina()));

        scan.nextLine();

        System.out.print("Você deseja ligar o carro agora? (y/n) ");
        if (scan.nextLine().contains("y")){
            System.out.println(c1.ligar());
        }else {
            System.out.println(c1.desligar());
        }
        System.out.print("Qual velocidade você está dirigindo? ");
        velocidade = scan.nextInt();
        System.out.print("Qual a distância que você quer percorrer? ");
        distancia = scan.nextDouble();
        System.out.println(c1.acelerar(velocidade, distancia));
    }
}
