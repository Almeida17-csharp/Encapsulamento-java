# Projeto de Encapsulamento em Java

Este projeto foi desenvolvido como parte de uma atividade acadêmica para aplicar os conceitos de **Programação Orientada a Objetos (POO)**, com foco no pilar de **Encapsulamento**. O sistema é executado via console e está dividido no padrão arquitetural Model-View.

## 📌 Sobre o Projeto

O objetivo principal é garantir a integridade dos dados protegendo os atributos das classes (utilizando o modificador `private`) e permitindo a alteração e visualização desses dados apenas através de métodos públicos (`getters`, `setters` e métodos de negócio com validações).

## ⚙️ Funcionalidades

O sistema possui um menu interativo com três módulos principais:

*   **🚗 Sistema de Carros:**
    *   Cadastro de novos veículos (Marca, Modelo, Placa, Capacidade do Tanque).
    *   Cálculo do valor total para encher o tanque com base no preço da gasolina atual.
    *   Simulação de aceleração (cálculo de tempo baseado em velocidade e distância).
*   **🏦 Sistema Bancário (PathBank):**
    *   Cadastro de Usuários e vinculação à Conta Bancária.
    *   Depósitos e Saques com validação de saldo insuficiente e impedimento de valores negativos.
    *   Transferências seguras entre contas cadastradas.
*   **📦 Gerenciamento de Estoque (Produtos):**
    *   Cadastro de novos produtos.
    *   Validação estrita no *setter* de Preço (não aceita valores negativos).
    *   Validação no *setter* de Quantidade em Estoque (apenas valores maiores ou iguais a zero).

## 🚀 Como Executar

1. Certifique-se de ter o **Java JDK** instalado em sua máquina.
2. Clone este repositório:
   ```bash
   git clone URL_DO_SEU_REPOSITORIO