package model;

public class Funcionario {
	private String nome;
	private double salario;
	private String cargo;
	
	public Funcionario() {
		super();
	}
	
	public void getSalarioLiquido (double descontos, double beneficios) {
		salario = salario - descontos;
		salario = salario + beneficios;
		setSalario(salario);
	}
	
	
	//get e set NOME
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	//get e set SALARIO
	public double getSalario() {
		return salario;
	}
	
	public void setSalario (double salario) {
		if (salario < 1412) {
			this.salario = 1412.00;
		} else {			
			this.salario = salario;
		}
	}
	
	//get e set CARGO
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
