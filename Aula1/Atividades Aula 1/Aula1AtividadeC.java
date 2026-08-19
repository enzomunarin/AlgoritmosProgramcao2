import javax.swing.*;

public class Aula1AtividadeC {
    public static void main(String[] args) {
        int[] A = new int[20];
        int[] B = new int[20];
        int[] C = new int[20];

        for (int i = 0; i < 20; i++) {
            A[i] = Integer.parseInt(
                    JOptionPane.showInputDialog("Digite o " + (i + 1) + "º número do vetor A:")
            );
            B[i] = Integer.parseInt(
                    JOptionPane.showInputDialog("Digite o " + (i + 1) + "º número do vetor B:")
            );
            C[i] = A[i] - B[i];
        }

        String numerosC = "";
        for (int i = 0; i < A.length; i++) {
            numerosC += C[i] + " ";
        }


        JOptionPane.showMessageDialog(null, numerosC);
    }
}