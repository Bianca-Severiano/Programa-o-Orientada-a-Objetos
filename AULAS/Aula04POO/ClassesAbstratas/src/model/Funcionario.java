package model;

public abstract class Funcionario {
	private String CPF;
	private String nome;
	
	public Funcionario() {
		super();
	}
	
	
	public abstract double calcSalario(int horas);
	public abstract double calcBonus();
	

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
