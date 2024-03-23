package model;

public class Automovel {
	private String placa;
	private String marca;
	private int potencia;
	
	public Automovel(String placa, String marca, int potencia) {
		this.placa = placa;
		this.marca = marca;
		this.potencia = potencia;
	}

	
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	
}
