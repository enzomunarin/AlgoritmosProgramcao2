import javax.swing.*;

public class Aula1AtividadeA {
    public static void main(String[] args) {
        int[] numeros = new int[10];

        for (int i = 0; i < 10; i++) {
            numeros[i] = Integer.parseInt(
                    JOptionPane.showInputDialog("Digite o " + (i + 1) + "º número:")
            );
        }

        String numeroListados = "";

        for (int i = 0; i < 10; i++) {
            numeroListados += numeros[i] + " ";
        }

        JOptionPane.showMessageDialog(null, numeroListados);
    }
}