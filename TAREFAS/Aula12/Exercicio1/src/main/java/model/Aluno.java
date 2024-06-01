package model;

public class Aluno {
    
    private int RA;
    private String nome;
    private String email;

    public Aluno() {
        super();
    }

    public int getRA() {
        return RA;
    }

    public void setRA(int rA) {
        RA = rA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", RA: "+ RA + ", E-mail: " + email;
    }

}
