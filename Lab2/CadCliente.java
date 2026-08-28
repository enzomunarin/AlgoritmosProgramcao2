package Aula2Atividade;

import javax.swing.*;
import java.util.ArrayList;

public class CadCliente {

    ArrayList<Cliente> clientes = new ArrayList<>();

    public void cadCliente() {
        String nome = JOptionPane.showInputDialog(
                "Digite o nome:"
        );

        int idade = Integer.parseInt(JOptionPane.showInputDialog(
                "Digite a idade:"
        ));

        String email = JOptionPane.showInputDialog(
                "Digite o email:"
        );

        String cpf = JOptionPane.showInputDialog(
                "Digite o cpf:"
        );

        // instancia o cliente(cria o objeto cliente)

        Cliente cliente = new Cliente(nome, idade, email, cpf);

        // add para o array
        clientes.add(cliente);

        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
    }


    public void alterarCliente() {
        String cpf = JOptionPane.showInputDialog(
                "Informe o cpf:"
        );

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                int opcao;

                opcao = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "MENU\n" +
                                        "1 - Alterar Nome\n" +
                                        "2 - Alterar Idade\n" +
                                        "3 - Alterar Emaill\n" +
                                        "4 - Alterar Cpf\n" +
                                        "5 - Sair\n\n" +
                                        "Escolha uma opção:"
                        )
                );

                switch (opcao) {
                    case 1:
                        String nome = JOptionPane.showInputDialog(
                                "Digite o nome:"
                        );

                        cliente.setNome(nome);

                        JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
                        break;
                    case 2:
                        int idade = Integer.parseInt(JOptionPane.showInputDialog(
                                "Digite a idade:"
                        ));

                        cliente.setIdade(idade);
                        JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
                        break;
                    case 3:
                        String email = JOptionPane.showInputDialog(
                                "Digite o email:"
                        );

                        cliente.setEmail(email);
                        JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
                        break;
                    case 4:
                        String cpff = JOptionPane.showInputDialog(
                                "Digite o cpf:"
                        );

                        cliente.setCpf(cpff);
                        JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(
                                null,
                                "Opção inválida."
                        );
                }

            }
        }
    }

    public void exibirClientes() {
        String mensagem = "";

        for (Cliente cliente : clientes) {
            mensagem +=
                    "Nome: " + cliente.getNome() + "\n" +
                            "Idade: " + cliente.getIdade() + "\n" +
                            "Email: " + cliente.getEmail() + "\n" +
                            "CPF: " + cliente.getCpf() + "\n\n";
        }

        JOptionPane.showMessageDialog(null, mensagem);
    }


    public void main(String[] args) {
        int opcao;

        do {
            opcao = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "MENU\n" +
                                    "1 - Cadastrar Cliente\n" +
                                    "2 - Alterar Cliente\n" +
                                    "3 - Exibir Clientes\n" +
                                    "4- Sair\n\n" +
                                    "Escolha uma opção:"
                    )
            );

            switch (opcao) {
                case 1:
                    cadCliente();
                    break;
                case 2:
                    alterarCliente();
                    break;
                case 3:
                    exibirClientes();
                    break;
                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opção inválida."
                    );
            }
        } while (opcao != 4);
    }
}
