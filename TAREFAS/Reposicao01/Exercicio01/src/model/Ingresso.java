package model;

public class Ingresso {
	private String identificador;
	private float valor;
	
	public Ingresso() {
		super();
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public float valorFinal(float taxaConveniencia) {
		return valor + (valor * taxaConveniencia);
	}

	public void dados() {
		System.out.println("Ingresso [identificador=" + identificador + ", valor=" + valor + "]");
	}

 
	
}
