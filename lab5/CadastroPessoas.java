import java.util.Scanner;

public class CadastroPessoas {

    static Scanner entrada = new Scanner(System.in);

    static String[] nomes = new String[100];
    static String[] emails = new String[100];
    static String[] rgs = new String[100];

    static int quantidade = 0;

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n========================================");
            System.out.println("       SISTEMA DE CADASTRO DE PESSOAS");
            System.out.println("========================================");
            System.out.println("1 - Ler Nome, Email e RG");
            System.out.println("2 - Exibir tudo lado a lado");
            System.out.println("3 - Classificar por Nome - Selection Sort");
            System.out.println("4 - Classificar por Nome - Insertion Sort");
            System.out.println("5 - Classificar por RG - Selection Sort");
            System.out.println("6 - Classificar por RG - Insertion Sort");
            System.out.println("7 - Buscar um RG - Busca Binária");
            System.out.println("8 - Buscar um Nome - Busca Binária");
            System.out.println("9 - Finalizar programa");
            System.out.println("========================================");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1:
                    lerPessoa();
                    break;

                case 2:
                    exibirTudo();
                    break;

                case 3:
                    selectionSortNome();
                    System.out.println("\nNomes classificados com Selection Sort!");
                    break;

                case 4:
                    insertionSortNome();
                    System.out.println("\nNomes classificados com Insertion Sort!");
                    break;

                case 5:
                    selectionSortRG();
                    System.out.println("\nRGs classificados com Selection Sort!");
                    break;

                case 6:
                    insertionSortRG();
                    System.out.println("\nRGs classificados com Insertion Sort!");
                    break;

                case 7:
                    buscarRG();
                    break;

                case 8:
                    buscarNome();
                    break;

                case 9:
                    System.out.println("\nPrograma finalizado.");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }

        } while (opcao != 9);

        entrada.close();
    }

   
    public static void lerPessoa() {

        if (quantidade >= nomes.length) {
            System.out.println("Limite de cadastros atingido!");
            return;
        }

        System.out.println("\n--- NOVO CADASTRO ---");

        System.out.print("Nome completo: ");
        nomes[quantidade] = entrada.nextLine();

        System.out.print("E-mail: ");
        emails[quantidade] = entrada.nextLine();

        System.out.print("RG: ");
        rgs[quantidade] = entrada.nextLine();

        quantidade++;

        System.out.println("\nPessoa cadastrada com sucesso!");
    }

    

    public static void exibirTudo() {

        if (quantidade == 0) {
            System.out.println("\nNenhuma pessoa cadastrada.");
            return;
        }

        System.out.println("\n==============================================================");
        System.out.printf("%-30s %-30s %-15s%n", "NOME", "E-MAIL", "RG");
        System.out.println("==============================================================");

        for (int i = 0; i < quantidade; i++) {
            System.out.printf("%-30s %-30s %-15s%n",
                    nomes[i], emails[i], rgs[i]);
        }

        System.out.println("==============================================================");
    }


    public static void selectionSortNome() {

        for (int i = 0; i < quantidade - 1; i++) {

            int menor = i;

            for (int j = i + 1; j < quantidade; j++) {

                if (nomes[j].compareToIgnoreCase(nomes[menor]) < 0) {
                    menor = j;
                }
            }

            if (menor != i) {
                trocar(i, menor);
            }
        }
    }

    public static void insertionSortNome() {

        for (int i = 1; i < quantidade; i++) {

            String nomeTemp = nomes[i];
            String emailTemp = emails[i];
            String rgTemp = rgs[i];

            int j = i - 1;

            while (j >= 0 &&
                   nomes[j].compareToIgnoreCase(nomeTemp) > 0) {

                nomes[j + 1] = nomes[j];
                emails[j + 1] = emails[j];
                rgs[j + 1] = rgs[j];

                j--;
            }

            nomes[j + 1] = nomeTemp;
            emails[j + 1] = emailTemp;
            rgs[j + 1] = rgTemp;
        }
    }

    
    public static void selectionSortRG() {

        for (int i = 0; i < quantidade - 1; i++) {

            int menor = i;

            for (int j = i + 1; j < quantidade; j++) {

                if (rgs[j].compareTo(rgs[menor]) < 0) {
                    menor = j;
                }
            }

            if (menor != i) {
                trocar(i, menor);
            }
        }
    }


    public static void insertionSortRG() {

        for (int i = 1; i < quantidade; i++) {

            String nomeTemp = nomes[i];
            String emailTemp = emails[i];
            String rgTemp = rgs[i];

            int j = i - 1;

            while (j >= 0 &&
                   rgs[j].compareTo(rgTemp) > 0) {

                nomes[j + 1] = nomes[j];
                emails[j + 1] = emails[j];
                rgs[j + 1] = rgs[j];

                j--;
            }

            nomes[j + 1] = nomeTemp;
            emails[j + 1] = emailTemp;
            rgs[j + 1] = rgTemp;
        }
    }

   
    public static void trocar(int i, int j) {

        String temp;

        temp = nomes[i];
        nomes[i] = nomes[j];
        nomes[j] = temp;

        temp = emails[i];
        emails[i] = emails[j];
        emails[j] = temp;

        temp = rgs[i];
        rgs[i] = rgs[j];
        rgs[j] = temp;
    }

    

    public static void buscarRG() {

        if (quantidade == 0) {
            System.out.println("\nNenhuma pessoa cadastrada.");
            return;
        }

        insertionSortRG();

        System.out.print("\nDigite o RG que deseja buscar: ");
        String rgBusca = entrada.nextLine();

        int inicio = 0;
        int fim = quantidade - 1;

        while (inicio <= fim) {

            int meio = (inicio + fim) / 2;

            int comparacao = rgs[meio].compareTo(rgBusca);

            if (comparacao == 0) {

                System.out.println("\nPessoa encontrada!");
                System.out.println("Nome : " + nomes[meio]);
                System.out.println("Email: " + emails[meio]);
                System.out.println("RG   : " + rgs[meio]);

                return;

            } else if (comparacao < 0) {

                inicio = meio + 1;

            } else {

                fim = meio - 1;
            }
        }

        System.out.println("\nRG não encontrado.");
    }

    
    public static void buscarNome() {

        if (quantidade == 0) {
            System.out.println("\nNenhuma pessoa cadastrada.");
            return;
        }

        // Para a busca binária funcionar, primeiro
        // precisamos ordenar os dados pelo nome.
        insertionSortNome();

        System.out.print("\nDigite o nome que deseja buscar: ");
        String nomeBusca = entrada.nextLine();

        int inicio = 0;
        int fim = quantidade - 1;

        while (inicio <= fim) {

            int meio = (inicio + fim) / 2;

            int comparacao =
                    nomes[meio].compareToIgnoreCase(nomeBusca);

            if (comparacao == 0) {

                System.out.println("\nPessoa encontrada!");
                System.out.println("Nome : " + nomes[meio]);
                System.out.println("Email: " + emails[meio]);
                System.out.println("RG   : " + rgs[meio]);

                return;

            } else if (comparacao < 0) {

                inicio = meio + 1;

            } else {

                fim = meio - 1;
            }
        }

        System.out.println("\nNome não encontrado.");
    }
}

