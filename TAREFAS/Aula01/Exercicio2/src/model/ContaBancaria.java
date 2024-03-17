package model;

public class ContaBancaria {
	public int numeroConta;
	public String nome;
	public double saldo;
	
	public ContaBancaria() {
		super();
	}
	
	public void realizarDeposito(double valor) {
		saldo = saldo + valor;
	}
	
	public void realizarSaque(double valor) {
		saldo = saldo - valor;
	}
	
	
}
