package me.banco;

import java.awt.*;
import java.util.Scanner;

public class Banco {
    Scanner teclado = new Scanner(System.in);
    private String nome;
    private Double saldo, valorDeposito, valorSacar;
    private int numeroConta, contasCriadas = 000000;
    private boolean estado;
    public void abrirConta(){
        System.out.println("Qual seu nome completo?");
        nome = teclado.nextLine();
        System.out.println("Qual valor inicial para a conta?");
        saldo = teclado.nextDouble();
        numeroConta = contasCriadas + 000001;
        contasCriadas += 1;
        estado = true;
    }

    public String getProprietario(){
        return nome;
    }

    public Double getSaldo(){
        return saldo;
    }

    public boolean getEstado(){
        return estado;
    }

    public int getNumero(){
        return numeroConta;
    }
    public void estado(){
        System.out.println("");
        System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
        System.out.println("Proprietario: " + this.getProprietario());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Número da conta: " + this.getNumero());
        System.out.println("Estado: " + this.getEstado());
        System.out.println("Conta aberta com sucesso!");
        System.out.printf("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");

    }

    public void depositar(){
        if (getEstado() == true) {
            System.out.println("Olá, " + nome + " Deseja depositar qual valor?");
            valorDeposito = teclado.nextDouble();
            saldo = valorDeposito + saldo;
            System.out.println("R$ " + valorDeposito + " Depositado com sucesso!");
            System.out.println(nome + " Seu saldo atual é de R$ " + saldo);
            this.acaoConta();
        }else{
            System.out.println("Sua conta está fechada, caso queira voltar a usar entre em contato com o banco!");
        }
    }

    public void sacar(){
        if (getEstado() == true){
            System.out.println("Olá, " + nome + " Deseja sacar qual valor?");
            valorSacar = teclado.nextDouble();
            saldo = valorSacar - saldo;
            System.out.println("R$ " + valorSacar + " Sacado com sucesso!");
            System.out.println(nome + " Seu saldo atual é de R$ " + saldo);
            this.acaoConta();
        }else{
            System.out.println("Sua conta está fechada, caso queira voltar a usar entre em contato com o banco!");
        }

    }

    public void fecharConta(){
        if (getEstado() == true){
            System.out.println("Olá, " + nome + " Você está tentando fechar a conta.");
            System.out.println("Percebemos que em sua conta tem saldo, recomendamos que saque ou transfera o dinheiro antes de fechar");
            System.out.println("Caso ainda queira continuar digite sim");
            String opcao3 = teclado.nextLine();
            if (opcao3.equalsIgnoreCase("sim")){
                System.out.println("Iniciamos o fechamento da sua conta!");
                System.out.println("Conta fechada com sucesso, caso queira voltar a usar entre em contato com o banco!");
                estado = false;
                this.acaoConta();
            }else{
                System.exit(0);
            }
        }else{
            System.out.println("Sua conta ja esta fechada, caso queira voltar a usar entre em contato com o banco!");
        }
    }

    public void acaoConta(){
        System.out.println("Oque deseja fazer?");
        System.out.println("1- Depositar\n2- Sacar\n3- Fechar Conta\n4- Sair");
        int opcao1 = teclado.nextInt();
        switch (opcao1){
            case 1:
                this.depositar();
                break;
            case 2:
                this.sacar();
                break;
            case 3:
                this.fecharConta();
                break;
            case 4:
                System.out.println("Sistema Finalizado");
                System.exit(0);
                break;
        }
    }
}
