package model;

public class Produto {
	private String nome;
	private float preco;
	private int qtdEstoque;
	
	
	public Produto() {
		super();
	
	}
	
	public boolean verificaProdutoDisponivel(String nome) {
		if (nome == this.nome && this.qtdEstoque > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public float totalValorEstoque() {
		float totalValorEstoque = this.preco * this.qtdEstoque;
		return totalValorEstoque;
	}
	
	
	// get e set NOME
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	// get e set PRECO
	public float getPreco () {
		return preco;
	}
	
	public void setPreco(float preco) {
		if (preco < 0) {
			this.preco = 10;
		} else {
			this.preco = preco;
		}
	}
	
	// get e set ESTOQUE
	public int getQtdEstoque() {
		return qtdEstoque;
	} 
	
	public void setQtdEstoque(int qtdEstoque) {
		if (qtdEstoque < 0) {
			this.qtdEstoque = 0;
		} else {			
			this.qtdEstoque = qtdEstoque;
		}
	}
	
}
