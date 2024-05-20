package model;

public class Time {

	private int codigo;
	private String nome;
	private String Cidade;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	
	@Override
	public String toString() {
		return "Codigo:" + codigo + "\n Nome: " + nome;
	}
}
