package Aula2Atividade;

public class Cliente {
    private String nome;
    private int idade;
    private String email;
    private String cpf;

    public Cliente() {}

    public Cliente(String nome, int idade, String email, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cpf = cpf;
    }

    // métodos getters

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCpf() {
        return this.cpf;
    }

    // métodos setters

    public String setNome(String nome) {
        return this.nome = nome;
    }

    public int setIdade(int idade) {
        return this.idade = idade;
    }

    public String setEmail(String email) {
        return this.email = email;
    }

    public String setCpf(String cpf) {
        return this.cpf = cpf;
    }
}
