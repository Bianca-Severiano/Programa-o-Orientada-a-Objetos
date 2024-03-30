package model;

public class Animal {
	private String nome;
	private float comprimento;
	private int num_patas;
	private String cor;
	private String ambiente;
	private float velocidade;
	
	public Animal() {
		super();
		this.num_patas = 4;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getComprimento() {
		return comprimento;
	}

	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}

	public int getNum_patas() {
		return num_patas;
	}

	public void setNum_patas(int num_patas) {
		this.num_patas = num_patas;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(float velocidade) {
		this.velocidade = velocidade;
	}


	public void dados() {
		System.out.println("Animal [nome=" + nome + ", comprimento=" + comprimento + ", num_patas=" + num_patas + ", cor=" + cor
				+ ", ambiente=" + ambiente + ", velocidade=" + velocidade + "]");
	}
	
	
	
	
}
