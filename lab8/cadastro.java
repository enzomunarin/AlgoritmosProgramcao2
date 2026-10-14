
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class cadastro {

    static ArrayList<Aluno> alunos = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;

        do {
            String menu =
                "1 - Cadastrar aluno\n"
              + "2 - Listar alunos\n"
              + "3 - Ordenar por e-mail (Quick Sort)\n"
              + "4 - Ordenar por RG (Merge Sort)\n"
              + "0 - Sair";

            String entrada = JOptionPane.showInputDialog(menu);

            if (entrada == null) {
                break;
            }

            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                    null, "Digite uma opção válida."
                );
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;

                case 2:
                    listarAlunos();
                    break;

                case 3:
                    quickSort(0, alunos.size() - 1);
                    JOptionPane.showMessageDialog(
                        null, "Alunos ordenados por e-mail!"
                    );
                    break;

                case 4:
                    if (!alunos.isEmpty()) {
                        mergeSort(0, alunos.size() - 1);
                    }
                    JOptionPane.showMessageDialog(
                        null, "Alunos ordenados por RG!"
                    );
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando...");
                    break;

                default:
                    JOptionPane.showMessageDialog(
                        null, "Opção inválida."
                    );
            }

        } while (true);
    }

    static void cadastrarAluno() {
        try {
            String nome = JOptionPane.showInputDialog("Nome:");
            if (nome == null) return;

            String email = JOptionPane.showInputDialog("E-mail:");
            if (email == null) return;

            String rg = JOptionPane.showInputDialog("RG:");
            if (rg == null) return;

            double p1 = Double.parseDouble(
                JOptionPane.showInputDialog("Nota P1:")
            );
            double p2 = Double.parseDouble(
                JOptionPane.showInputDialog("Nota P2:")
            );
            double ado = Double.parseDouble(
                JOptionPane.showInputDialog("Nota ADO:")
            );

            alunos.add(new Aluno(nome, email, rg, p1, p2, ado));

            JOptionPane.showMessageDialog(
                null, "Aluno cadastrado com sucesso!"
            );

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                null, "Digite notas numéricas válidas."
            );
        }
    }

    static void listarAlunos() {
        if (alunos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado.");
            return;
        }

        StringBuilder saida = new StringBuilder();

        for (Aluno aluno : alunos) {
            saida.append(aluno.toString())
                 .append("\n--------------------\n");
        }

        JOptionPane.showMessageDialog(null, saida.toString());
    }

    // QUICK SORT: ordena pelo e-mail
    static void quickSort(int inicio, int fim) {
        if (inicio >= fim) return;

        int i = inicio;
        int j = fim;
        String pivo = alunos.get((inicio + fim) / 2)
                            .getEmail();

        while (i <= j) {
            while (alunos.get(i).getEmail()
                    .compareToIgnoreCase(pivo) < 0) {
                i++;
            }

            while (alunos.get(j).getEmail()
                    .compareToIgnoreCase(pivo) > 0) {
                j--;
            }

            if (i <= j) {
                Aluno temp = alunos.get(i);
                alunos.set(i, alunos.get(j));
                alunos.set(j, temp);

                i++;
                j--;
            }
        }

        if (inicio < j) quickSort(inicio, j);
        if (i < fim) quickSort(i, fim);
    }

    // MERGE SORT: ordena pelo RG
    static void mergeSort(int inicio, int fim) {
        if (inicio >= fim) return;

        int meio = (inicio + fim) / 2;

        mergeSort(inicio, meio);
        mergeSort(meio + 1, fim);

        mesclar(inicio, meio, fim);
    }

    static void mesclar(int inicio, int meio, int fim) {
        List<Aluno> esquerda =
            new ArrayList<>(alunos.subList(inicio, meio + 1));

        List<Aluno> direita =
            new ArrayList<>(alunos.subList(meio + 1, fim + 1));

        int i = 0;
        int j = 0;
        int k = inicio;

        while (i < esquerda.size() && j < direita.size()) {
            if (esquerda.get(i).getRg()
                    .compareToIgnoreCase(direita.get(j).getRg()) <= 0) {
                alunos.set(k++, esquerda.get(i++));
            } else {
                alunos.set(k++, direita.get(j++));
            }
        }

        while (i < esquerda.size()) {
            alunos.set(k++, esquerda.get(i++));
        }

        while (j < direita.size()) {
            alunos.set(k++, direita.get(j++));
        }
    }
}
