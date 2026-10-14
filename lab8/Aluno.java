
public class Aluno {
    private String nome;
    private String email;
    private String rg;
    private double p1;
    private double p2;
    private double ado;
    private double media;

    public Aluno(String nome, String email, String rg,
                 double p1, double p2, double ado) {
        this.nome = nome;
        this.email = email;
        this.rg = rg;
        this.p1 = p1;
        this.p2 = p2;
        this.ado = ado;
        calcularMedia();
    }

    public void calcularMedia() {
        media = (p1 + p2 + ado) / 3.0;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getRg() {
        return rg;
    }

    public double getMedia() {
        return media;
    }

    @Override
    public String toString() {
        return "Nome: " + nome
             + "\nE-mail: " + email
             + "\nRG: " + rg
             + "\nMédia: " + String.format("%.2f", media);
    }
}
