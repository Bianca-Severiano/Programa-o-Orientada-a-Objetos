package model;

public abstract class Veiculo {
	private String marca;
	private String modelo;
	private int velocidadeMaxima;
	
	public Veiculo() {
		super();
	}
	
	public abstract void ateCemPorHora();
	

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(int velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}

	@Override
	public String toString() {
		return "Veiculo [marca=" + marca + ", modelo=" + modelo + ", velocidadeMaxima=" + velocidadeMaxima + "]";
	}
	
	
}
