package model;

public class Livro extends Produto{
	private String autor;
	private int qtdPaginas;
	
	public Livro() {
		super();
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getQtdPaginas() {
		return qtdPaginas;
	}

	public void setQtdPaginas(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}
	
	public boolean ehGrande() {
		return (this.qtdPaginas > 200);
	}
	

}
