package model;

public class Peixe extends Animal{
	private String caracteristica;

	public Peixe() {
		setNum_patas(0);
		setAmbiente("Mar");
		setCor("Cinzento");
		this.caracteristica = "Barbatanas e cauda";
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}


	public void dados() {
		System.out.println("Peixe [nome=" + getNome() + ", comprimento=" + getComprimento() + ", num_patas=" + getNum_patas() + ", cor=" + getCor()
				+ ", ambiente=" +getAmbiente() + ", velocidade=" + getVelocidade() + " caracteristica=" + caracteristica + "]");

	}


	
	
}
