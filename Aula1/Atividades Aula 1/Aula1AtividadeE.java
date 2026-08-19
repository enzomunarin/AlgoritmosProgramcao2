import javax.swing.*;

public class Aula1AtividadeE {
    public static void main(String[] args) {
        int[] A = new int[15];
        int[] B = new int[15];
        int[] C = new int[30];

        for (int i = 0; i < 15; i++) {
            A[i] = Integer.parseInt(
                    JOptionPane.showInputDialog("Digite o " + (i + 1) + "º número do vetor A:")
            );
            B[i] = Integer.parseInt(
                    JOptionPane.showInputDialog("Digite o " + (i + 1) + "º número do vetor B:")
            );
        }

        for (int i = 0; i < 30; i++) {
            if (i < 15) {
                C[i] = A[i];
            } else {
                C[i] = B[i - 15];
            }
        }

        String vetorC = "C: ";

        for (int i = 0; i < 30; i++) {
            vetorC += C[i] + " ";
        }

        JOptionPane.showMessageDialog(null, vetorC);
    }
}
