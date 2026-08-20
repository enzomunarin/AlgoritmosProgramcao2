public class Aluno {  // EXEMPLO CLASSE2.JAVA
    private String nome;
    private double media;
    private double p1;
    private double p2;
    private double ado;

    public Aluno(String nome, double p1, double p2, double ado)

    public void setNome (String nome) { this.nome = nome; }
    public void setP1 (double p1) { this.p1 = p1; }
    public void setP2 (double p2) { this.p2 = p2; }
    public void setAdo (double ado) { this.ado = ado; }
    public void setMedia() { this.media = (p1 + p2 + ado) / 3; }
    public double getP1 () { return p1; }
    public double getP2 () { return p2; }
    public double getAdo () { return ado; }
    public String getNome () { return nome; }
    public double getMedia() { return media; }  }


