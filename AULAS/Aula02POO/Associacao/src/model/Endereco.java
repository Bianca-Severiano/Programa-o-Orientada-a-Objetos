package model;

public class Endereco {
	private String lograduro;
	private int numero;
	private String CEP;
	
	
	
	public Endereco() {
		super();
	}
	public String getLograduro() {
		return lograduro;
	}
	public void setLograduro(String lograduro) {
		this.lograduro = lograduro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		if (numero < 1) {
			this.numero = 1;
		} else {
			this.numero = numero;			
		}
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	
	
}
