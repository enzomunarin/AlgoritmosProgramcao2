package Aula7;

import javax.swing.*;

public class Pilha {
    public Object pil []; // vetor de objetos
    public int topo; // posição do topo
    public int max; // tamanho limite
    public int tamanho = 0; // tamanho preenchido

    public Pilha(int max) {
        this.max = max;
        this.topo = -1;
        pil = new Object[max];
    }

    public void push(Object obj) {
        if (tamanho >= max) {
            JOptionPane.showMessageDialog(null, "Pilha Cheia!");
            return;
        }
        topo ++;
        pil [ topo ] = obj;
        tamanho ++;
    }

    public void print() {
        if (topo == -1) return;
        String saida = "";
        for (int i = topo; i >= 0; i--) {
            saida += "\n" + pil[i];
        }
        JOptionPane.showMessageDialog(null, saida);
    }

    public void print2() {
        if (topo == -1) return;
        String saida = "";
        for (int i = topo; i >= 0; i--) {
            Notas nota = (Notas) pil[i];

            if (nota != null) {
                saida += "\nNome: " + nota.getNome() + " | Média: " + nota.getMedia();
            } else {
                saida += "Ninguem na lista";
            }
        }
        JOptionPane.showMessageDialog(null, saida);
    }

    public void pop() {
        if (topo == -1) {
            JOptionPane.showMessageDialog(null, "Pilha já está vazia!");
            return;
        }
        pil [ topo ] = null;
        topo--;
        tamanho--;
    }


    public void destrutor ( int topo ) {
        if ( topo == -1) { // condição de parada recursivo
            JOptionPane.showMessageDialog(null,"Pilha destruída...!");
            return;
        }
        pil [ topo ] = null;
        destrutor ( topo - 1 );
    }

    public boolean vazia () {
        if (topo ==-1) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean cheia () {
        if (tamanho == max ) {
            return true;
        } else {
            return false;
        }

    }


}
