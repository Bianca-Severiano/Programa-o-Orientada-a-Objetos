package model;

public class Pessoa {
	private String nome;

	public Pessoa() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + "]";
	}
	
	
	
}
