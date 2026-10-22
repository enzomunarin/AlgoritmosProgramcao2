package Aula7;

public class Notas {
    private String nome;
    private double media;

    public Notas(String nome, double media) {
        this.nome = nome;
        this.media = media;
    }

    public String getNome() {
        return this.nome;
    }

    public double getMedia() {
        return this.media;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + " | Média: " + this.media;
    }
}
