import javax.swing.*;

public class Aula1Atividade1 {
    public static int linha = -1;

    public static String[] nome = new String[20];
    public static double[] nota1 = new double[20];
    public static double[] nota2 = new double[20];
    public static double[] media = new double[20];

    public static void ler(String nom, Double n1, Double n2) {

        if (linha >= 20) {
            JOptionPane.showMessageDialog(
                    null,
                    "Limite de 20 alunos atingido!"
            );
            return;
        }

        linha++;

        nome[linha] = nom;
        nota1[linha] = n1;
        nota2[linha] = n2;
        media[linha] = (n1 + n2) / 2;
    }

    public static void exibir() {

        String saida = "";

        for (int i = 0; i <= linha; i++) {
            saida += nome[i] + " " + media[i] + "\n";
        }

        JOptionPane.showMessageDialog(null, saida);
    }

    public static void main(String[] args) {

        int opcao;

        do {

            opcao = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "MENU\n" +
                                    "1 - Inserir aluno\n" +
                                    "2 - Exibir alunos\n" +
                                    "3 - Sair\n\n" +
                                    "Escolha uma opção:"
                    )
            );

            switch (opcao) {
                case 1:
                    String nome = JOptionPane.showInputDialog(
                            "Digite nome:"
                    );

                    double n1 = Double.parseDouble(
                            JOptionPane.showInputDialog("Nota 1:")
                    );

                    double n2 = Double.parseDouble(
                            JOptionPane.showInputDialog("Nota 2:")
                    );

                    ler(nome, n1, n2);
                    break;
                case 2:
                    exibir();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(
                            null,
                            "Programa encerrado."
                    );
                    break;
                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opção inválida."
                    );
            }
        } while(opcao != 3);
    }
}