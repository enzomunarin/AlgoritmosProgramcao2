package Aula1;

public class Aula1Codigo1 {

    public static int[] xy = {1000, 5000, 4900, 7000};

    public static String[] nome = {
            "João",
            "Pedro",
            "Sara",
            "Leia"
    };

    public static void mostrar() {

        int imaior = 0;
        int imenor = 0;

        int tot = xy.length; // Pega o tamanho do array

        for (int i = 0; i < tot; i++) {

            if (i == 0) {
                imaior = i;
                imenor = i;
            }

            if (xy[i] > xy[imaior]) {
                imaior = i;
            }

            if (xy[i] < xy[imenor]) {
                imenor = i;
            }
        }

        System.out.println(
                String.format(
                        "Valor maior: %d %s",
                        xy[imaior],
                        nome[imaior]
                )
        );

        System.out.println(
                String.format(
                        "Valor menor: %d %s",
                        xy[imenor],
                        nome[imenor]
                )
        );
    }

    public static void main(String[] args) {
        mostrar();
    }
}