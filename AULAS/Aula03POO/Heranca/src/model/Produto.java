package model;

public class Produto {
	private String nome;
	private double preco;
	
	public Produto() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean ehCaro() {
		return (preco > 100);
	}

	
	public double valorComDesconto (int qtdPontos) {
		if (qtdPontos > 10) {
			return preco * 0.9d;
		} else {
			return preco;
		}
	}
	
	public double valorComDesconto (double valor) {
		if (valor > 1000.00d) {
			return preco * 0.85d;
		} else {
			return preco;
		}
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
	
}
