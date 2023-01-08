package me.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    private int opcao;
    private List<String> nome = new ArrayList<String>();
    private List<Double> saldo = new ArrayList<Double>();
    private List<Integer> numeroConta = new ArrayList<Integer>();
    private List<Integer> senha = new ArrayList<Integer>();
    private int  contasCriadas = 1, indice = -1, contaAcesso, indiceAcesso, senhaAcesso;
    private List<Boolean> estado = new ArrayList<Boolean>();
    private double valorDeposito, valorSacar;

    Scanner teclado = new Scanner(System.in);

    public void inicioSistema(){
        System.out.println("Bem-Vindo ao sistema do banco.");
        System.out.println("Você deseja abrir ou acessar uma conta?");
        System.out.println("1- Abrir, 2- Acessar");
        opcao = teclado.nextInt();
        switch (opcao){
            case 1:
                abrirConta();
                break;
            case 2:
                acessarConta();
                break;
        }
    }

    public void abrirConta(){
        indice += 1;
        System.out.println("Qual seu nome completo?");
        nome.add(teclado.nextLine());
        System.out.println("Qual valor inicial para a conta?");
        saldo.add(teclado.nextDouble());
        numeroConta.add(contasCriadas);
        contasCriadas += 1;
        estado.add(true);
        System.out.println("Digite uma senha para sua conta");
        senha.add(teclado.nextInt());
        opcao = -1;
        System.out.println("O numero da sua conta é: " + numeroConta.get(indice));
        estado();
    }

    public void acessarConta(){
        System.out.print("Digite o numero da sua conta: ");
        contaAcesso = teclado.nextInt();
        if (numeroConta.contains(contaAcesso)){
            System.out.println("Digite a senha da conta");
            encontrarAcesso();
            senhaAcesso = teclado.nextInt();
            if (senha.get(indiceAcesso) == senhaAcesso){
                System.out.println("Seja Bem-Vindo, " + nome.get(indiceAcesso));
                acaoConta();
            }else{
                System.out.println("Senha da conta incorreta!");
                inicioSistema();
            }
        }else{
            System.out.println("Não existi essa conta no sistema!");
            inicioSistema();
        }
    }

    public void encontrarAcesso(){
        for (int i=0; i<numeroConta.size(); i++){
            if (numeroConta.contains(contaAcesso)){
                if (numeroConta.get(i) == contaAcesso){
                    indiceAcesso = i;
                }
            }
        }

    }

    public void estado(){
        System.out.println("");
        System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
        System.out.println("Proprietario: " + nome.get(indice));
        System.out.println("Saldo: " + saldo.get(indice));
        System.out.println("Número da conta: " + numeroConta.get(indice));
        System.out.println("Estado: " + estado.get(indice));
        System.out.println("Conta aberta com sucesso!");
        System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
        inicioSistema();
    }

    public void depositar(){
        if (estado.get(indiceAcesso) == true) {
            System.out.println("Olá, " + nome.get(indiceAcesso) + " Deseja depositar qual valor?");
            valorDeposito = teclado.nextDouble();
            saldo.set(indiceAcesso, valorDeposito + saldo.get(indiceAcesso));
            System.out.println("R$ " + valorDeposito + " Depositado com sucesso!");
            System.out.println(nome.get(indiceAcesso) + " Seu saldo atual é de R$ " + saldo.get(indiceAcesso));
            this.acaoConta();
        }else{
            System.out.println("Sua conta está fechada, caso queira voltar a usar entre em contato com o banco!");
        }
    }

    public void sacar(){
        if (estado.get(indiceAcesso) == true){
            System.out.println("Olá, " + nome.get(indiceAcesso) + " Deseja sacar qual valor?");
            valorSacar = teclado.nextDouble();
            saldo.set(indiceAcesso, saldo.get(indiceAcesso) - valorSacar);
            System.out.println("R$ " + valorSacar + " Sacado com sucesso!");
            System.out.println(nome.get(indiceAcesso) + " Seu saldo atual é de R$ " + saldo.get(indiceAcesso));
            this.acaoConta();
        }else{
            System.out.println("Sua conta está fechada, caso queira voltar a usar entre em contato com o banco!");
        }

    }

    public void fecharConta(){
        if (estado.get(indiceAcesso) == true){
            System.out.println("Olá, " + nome.get(indiceAcesso) + " Você está tentando fechar a conta.");
            System.out.println("Iniciamos o fechamento da sua conta!");
            System.out.println("Conta fechada com sucesso, caso queira voltar a usar entre em contato com o banco!");
            estado.set(indiceAcesso, false);
            this.acaoConta();
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
                System.out.println("Saindo da conta");
                inicioSistema();
                break;
        }
    }
}
