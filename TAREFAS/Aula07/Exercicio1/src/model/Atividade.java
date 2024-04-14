package model;

public class Atividade {
	private char[] assunto;
	private int numeroPaginas;
	
	public Atividade(char[] assunto, int numeroPaginas) {
		super();
		this.assunto = assunto;
		this.numeroPaginas = numeroPaginas;
	}

	public char[] getAssunto() {
		return assunto;
	}

	public void setAssunto(char[] assunto) {
		this.assunto = assunto;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	@Override
	public String toString() {
		return "Atividade [assunto=" + new String (assunto) + ", numeroPaginas=" + numeroPaginas + "]";
	}
	
	
	
}
