import java.util.Scanner;

public class ADO3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n========================================");
            System.out.println("       MENU - ADO 3 (RECURSIVIDADE)     ");
            System.out.println("========================================");
            System.out.println("1. Potenciação (Exemplo 3)");
            System.out.println("2. Somatório de Inteiros (Exemplo 4)");
            System.out.println("3. Somatório de Números Reais entre X e Y");
            System.out.println("4. Fatorial Duplo (n!!)");
            System.out.println("5. Série de Fibonacci até um Limite");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a Base (b): ");
                    int b = scanner.nextInt();
                    System.out.print("Digite o Expoente (e): ");
                    int e = scanner.nextInt();
                    
                    System.out.println("--- Resultado (Recursivo) ---");
                    int resPotRec = potRecur(b, e);
                    System.out.println("Resultado: " + resPotRec);
                    
                    System.out.println("--- Resultado (Iterativo) ---");
                    int resPotIter = potIterativa(b, e);
                    System.out.println("Resultado: " + resPotIter);
                    break;

                case 2:
                    System.out.print("Digite o valor inicial (x): ");
                    int xInt = scanner.nextInt();
                    System.out.print("Digite o valor final (y): ");
                    int yInt = scanner.nextInt();
                    
                    System.out.println("--- Resultado (Recursivo) ---");
                    int resSomaRec = somaInt(xInt, yInt);
                    System.out.println("Somatório: " + resSomaRec);
                    
                    System.out.println("--- Resultado (Iterativo) ---");
                    int resSomaIter = somaIntIterativa(xInt, yInt);
                    System.out.println("Somatório: " + resSomaIter);
                    break;

                case 3:
                    System.out.print("Digite o valor real inicial (x): ");
                    double xReal = scanner.nextDouble();
                    System.out.print("Digite o valor real final (y): ");
                    double yReal = scanner.nextDouble();
                    
                    double resSomaReal = somaReal(xReal, yReal);
                    System.out.println("Somatório dos reais: " + resSomaReal);
                    break;

                case 4:
                    System.out.print("Digite um número para o Fatorial Duplo (n): ");
                    int nFat = scanner.nextInt();
                    int resFatDuplo = fatoDuplo(nFat);
                    System.out.println("Fatorial Duplo (" + nFat + "!!) = " + resFatDuplo);
                    break;

                case 5:
                    System.out.print("Digite o limite para a série de Fibonacci: ");
                    int limiteFibo = scanner.nextInt();
                    System.out.print("Série de Fibonacci até " + limiteFibo + ": ");
                    gerarFibo(limiteFibo);
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    
    // 1. POTENCIAÇÃO (EXEMPLO 3)
    
    public static int potRecur(int b, int e) {
        if (e == 0)
            return 1; 
        return (b * potRecur(b, e - 1)); 
    }

    public static int potIterativa(int b, int e) {
        int potencia = 1;
        for (int i = 1; i <= e; i++) {
            potencia = potencia * b;
        }
        return potencia;
    }

    
    // 2. SOMATÓRIO DE INTEIROS (EXEMPLO 4)
    
    public static int somaInt(int x, int y) {
        if (x == y)
            return y; 
        return (x + somaInt(x + 1, y)); 
    }

    public static int somaIntIterativa(int x, int y) {
        int soma = 0;
        for (int i = x; i <= y; i++) {
            soma += i;
        }
        return soma;
    }

   
    // 3. SOMATÓRIO DE NÚMEROS REAIS ENTRE X E Y
    
    public static double somaReal(double x, double y) {
        if (x > y)
            return 0.0; 
        return (x + somaReal(x + 1.0, y)); 
    }

    
    // 4. FATORIAL DUPLO (n!!)
   
    public static int fatoDuplo(int n) {
        if (n <= 1)
            return 1; 
        return n * fatoDuplo(n - 2); 
    }

    
    // 5. SÉRIE DE FIBONACCI ATÉ UM LIMITE
    
    // Função auxiliar para calcular o i-ésimo termo de Fibonacci recursivamente
    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    // Processo recursivo para gerar a série até o limite dado
    public static void gerarFiboAux(int limite, int i) {
        int f = fib(i);
        if (f > limite)
            return; 
        System.out.print(f + " ");
        gerarFiboAux(limite, i + 1); 
    }

    public static void gerarFibo(int n) {
        gerarFiboAux(n, 0);
        System.out.println();
    }
}