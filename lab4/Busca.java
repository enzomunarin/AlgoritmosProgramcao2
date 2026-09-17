import javax.swing.*;

public class Busca {
    public int n;
    public User [] listaUser;
    public int pos = -1;


    public Busca( int n ) {
        this.n = n;
        this.listaUser = new User[n];
    }

    public void inserir(String nome, int senha) {
        if (this.pos== this.n - 1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Maximo de pessoas ja cadastrado!"
            );

            return;
        };

        this.pos++;
        this.listaUser[pos] = new User();


        this.listaUser[pos].nome = nome;
        this.listaUser[pos].senha = senha;
    }

    public void listar() {
        if (this.pos == -1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Nenhum cadastro realizado!"
            );
            return;
        }

        String mensagem = "";

        for (int i = 0; i <= pos; i++) {
            mensagem += this.listaUser[i].nome + "\t\t " +  this.listaUser[i].senha + "\n";
        }

        JOptionPane.showMessageDialog(
                null,
                mensagem
        );
    }

    public void ordenar() {
        if (this.pos == -1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Nenhum cadastro realizado!"
            );
            return;
        }

        String auxNome;
        int auxSenha;
        boolean troca = true;

        while (troca) {
            troca = false;

            for (int j = 0; j < pos; j++) {
                if (this.listaUser[j].senha > this.listaUser[j + 1].senha) {

                    auxNome = this.listaUser[j].nome;
                    this.listaUser[j].nome = this.listaUser[j + 1].nome;
                    this.listaUser[j + 1].nome = auxNome;

                    auxSenha = this.listaUser[j].senha;
                    this.listaUser[j].senha = this.listaUser[j + 1].senha;
                    this.listaUser[j + 1].senha = auxSenha;

                    troca = true;
                }
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Senhas classificadas em ordem crescente!"
        );
    }

    public int buscarSenha(int senha) {
        int e = 0;
        int d = this.pos;

        int m = (e + d) / 2;

        for (int i = 0; i <= this.pos; i++) {
            m = (e + d) / 2;

            if (senha == this.listaUser[m].senha) {
                return m;
            } else {
                if (senha >= this.listaUser[m].senha) {
                    e = m + 1;
                } else {
                    d = m - 1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        String strn = JOptionPane.showInputDialog(null, "Qts Usuários: ");
        Busca b1 = new Busca(Integer.parseInt(strn));
        int strItem;
        String menu = "******** MENU DE CONTROLE ********\n\n"
                + "1 - Inserir novo nome e senha\n"
                + "2 - Listar nomes e senhas\n"
                + "3 - Ordenar por Bubble Sort\n"
                + "4 - Buscar senha por busca binária\n"
                + "5 - Finalizar\n\n"
                + "**********************************";
        while(true) {
            strItem = Integer.parseInt(JOptionPane.showInputDialog(null, menu));

            switch (strItem) {
                case 1:
                    String nome = JOptionPane.showInputDialog(null, "Digite o seu nome: ");
                    int senha = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite sua senha: "));

                    b1.inserir(nome, senha);
                    break;
                case 2:
                    b1.listar();
                    break;

                case 3:
                    b1.ordenar();
                    break;
                case 4:
                    int senhaUsuario = Integer.parseInt(
                            JOptionPane.showInputDialog(null, "Digite sua senha: ")
                    );

                    int indice = b1.buscarSenha(senhaUsuario);

                    if (indice != -1) {
                        String nomeEncontrado = b1.listaUser[indice].nome;
                        int senhaEncontrada = b1.listaUser[indice].senha;

                        JOptionPane.showMessageDialog(
                                null,
                                "Nome: " + nomeEncontrado +
                                        "\nSenha: " + senhaEncontrada +
                                        "\nPosição: " + indice
                        );
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "Senha não encontrada!"
                        );
                    }
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Programa finalizado!"
                    );
            }
        }
    }
}
