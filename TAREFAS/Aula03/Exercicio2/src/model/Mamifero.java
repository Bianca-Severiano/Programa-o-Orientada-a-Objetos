package model;

public class Mamifero extends Animal{
	private String comidaFavorita;
	
	public Mamifero() {
		setAmbiente("Terra");
	}

	public String getComidaFavorita() {
		return comidaFavorita;
	}

	public void setComidaFavorita(String comidaFavorita) {
		this.comidaFavorita = comidaFavorita;
	}

	public void dados() {
		System.out.println("Mamífero [nome=" + getNome() + ", comprimento=" + getComprimento() + ", num_patas=" + getNum_patas() + ", cor=" + getCor()
				+ ", ambiente=" +getAmbiente() + ", velocidade=" + getVelocidade() + " comidaFavorita=" + comidaFavorita + "]");

	}

}
