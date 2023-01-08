package me.banco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco bancosistema = new Banco();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bem-Vindo ao sistema do banco.");
        System.out.println("Você deseja abrir uma conta?");
        String opcao = teclado.nextLine();
        if (opcao.equalsIgnoreCase("sim")){
            bancosistema.abrirConta();
            bancosistema.estado();
            bancosistema.acaoConta();
        }else{
            System.out.println("Finalizando sistema do banco");
            System.out.println("Sistema Finalizado");
        }
    }
}
