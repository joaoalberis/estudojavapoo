package me.main;
import java.util.*;

public class Luta {
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds; 
    private int vencedor;
    private boolean aprovada;

    public void setDesafiado(Lutador dd){
        this.desafiado = dd;
    }

    public Lutador getDesafiado(){
        return this.desafiado;
    }

    public void setDesafiante(Lutador dd){
        this.desafiante = dd;
    }

    public Lutador getDesafiante(){
        return this.desafiante;
    }

    public void marcarLuta(Lutador l1, Lutador l2){
        if (l1.getCategoria().equals(l2.getCategoria()) && l1 != l2){
            this.aprovada = true;
            desafiado = l1;
            desafiante = l2;
        }else{
            this.aprovada = false;
            desafiado = null;
            desafiante = null;
        }

    }

    public void lutar(){
        if (aprovada){
            desafiado.apresentar();
            desafiante.apresentar();
            Random aleatorio = new Random();
            vencedor = aleatorio.nextInt(3);
            switch (vencedor){
                case 0:
                    System.out.println("Empatou");
                    desafiado.empatarLuta();
                    desafiante.empatarLuta();
                    break;
                case 1:
                    System.out.println(desafiado.getNome() + " Ganhou");
                    desafiado.ganharLuta();
                    desafiante.perderLuta();
                    break;
                case 2:
                    System.out.println(desafiante.getNome() + " Ganhou");
                    desafiante.ganharLuta();
                    desafiado.perderLuta();
                    break;
            }
        }else{
            System.out.println("Luta não pode acontecer");
        }
    }
}
