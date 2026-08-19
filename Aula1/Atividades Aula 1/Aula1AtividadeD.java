import javax.swing.*;

public class Aula1AtividadeD {
    public static void main(String[] args) {
        int[] A = new int[15];
        int[] B = new int[15];

        for(int i = 0; i < 15; i++) {
            A[i] = Integer.parseInt(
                    JOptionPane.showInputDialog("Digite o " + (i + 1) + "º número:")
            );

            B[i] = (int) Math.pow(A[i], 2);
        }

        String resultado = "A: ";

        for (int i = 0; i < 15; i++) {
            resultado += A[i] + " ";
        }

        resultado += "\nB: ";

        for (int i = 0; i < 15; i++) {
            resultado += B[i] + " ";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }
}
