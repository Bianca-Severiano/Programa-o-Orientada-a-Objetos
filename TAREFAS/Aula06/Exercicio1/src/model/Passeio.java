package model;

public final class Passeio extends Veiculo {
	private int qtdPassageiros;

	public Passeio() {
		super();
	}

	public int getQtdPassageiros() {
		return qtdPassageiros;
	}

	public final void setQtdPassageiros(int qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
	}

	@Override
	public float calcVel(float velocMax) {
		return velocMax/1000;
	}
	
	
	
}
