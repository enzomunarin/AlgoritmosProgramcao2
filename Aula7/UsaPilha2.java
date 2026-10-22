package Aula7;

import javax.swing.*;

public class UsaPilha2 {
    public static void main(String[] args) {
        String strn = JOptionPane.showInputDialog(
                null, "Deseja iniciar uma pilha com qual tamanho?"
        );

        int n = Integer.parseInt(strn);
        Pilha p1 = new Pilha(n);

        String menu = "*** Pilha Estática ***\n"
                + "1 - Empilhar aluno\n"
                + "2 - Listar alunos\n"
                + "3 - Remover aluno\n"
                + "4 - Destruir pilha\n"
                + "5 - Sair\n"
                + "Item:";

        while (true) {
            String item = JOptionPane.showInputDialog(null, menu);

            if (item == null) break;

            switch (item) {
                case "1":
                    String nome =  JOptionPane.showInputDialog(
                            "Digite o nome do aluno: "
                    );

                    if (nome == null) break;

                    String Stringmedia =  JOptionPane.showInputDialog(
                            "Digite a média do aluno: "
                    );

                    if (Stringmedia == null) break;

                    try {

                        double media = Double.parseDouble(
                                Stringmedia.replace(',', '.')
                        );
                        
                        Notas nota = new Notas(nome, media);
                        p1.push(nota);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(
                                null, "Digite uma média válida!"
                        );
                    }
                    break;
                case "2":
                    p1.print2();
                    break;
                case "3":
                    p1.pop();
                    break;
                case "4":
                    p1.destrutor(p1.topo);
                    break;
                case "5":
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null, "Opção inválida!"
                    );
            }
        }
    }
}
