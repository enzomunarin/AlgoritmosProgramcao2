package Aula7;

import javax.swing.JOptionPane;

public class Usapilha {
    public static void main(String[] args) {

        String strn = JOptionPane.showInputDialog(
                null, "Deseja iniciar uma pilha com qual tamanho?"
        );

        int n = Integer.parseInt(strn);
        Pilha p1 = new Pilha(n);

        String menu = "*** Pilha Estática ***\n"
                + "1 - Push\n"
                + "2 - Listar\n"
                + "3 - Pop\n"
                + "4 - Destruir\n"
                + "5 - Sair\n"
                + "Item:";

        while (true) {
            String item = JOptionPane.showInputDialog(null, menu);

            if (item == null) {
                break;
            }

            switch (item) {
                case "1":
                    String strDado = JOptionPane.showInputDialog(
                            null, "Digite alguma coisa para empilhar:"
                    );

                    if (strDado != null) {
                        p1.push(strDado);
                    }
                    break;

                case "2":
                    p1.print();
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
