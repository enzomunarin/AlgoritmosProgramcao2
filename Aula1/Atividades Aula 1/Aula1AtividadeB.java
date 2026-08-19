import javax.swing.*;

public class Aula1AtividadeB {
    public static void main(String[] args) {
        int[] A = new int[8];
        int[] B = new int[8];

        for (int i = 0; i < 8; i++) {
            A[i] = Integer.parseInt(
                    JOptionPane.showInputDialog("Digite o " + (i + 1) + "º número:")
            );
            B[i] = A[i] * 3;
        }

        String numerosB = "";
        for (int i = 0; i < A.length; i++) {
            numerosB += B[i] + " ";
        }


        JOptionPane.showMessageDialog(null, numerosB);
    }
}