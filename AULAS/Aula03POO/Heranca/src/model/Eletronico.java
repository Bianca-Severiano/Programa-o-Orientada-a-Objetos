package model;

public class Eletronico extends Produto {
	private int voltagem;

	public Eletronico() {
		super();
	}

	public int getVoltagem() {
		return voltagem;
	}

	public void setVoltagem(int voltagem) {
		this.voltagem = voltagem;
	}
	
	
	@Override 
	public boolean ehCaro() {
		return (getPreco() > 2000.00d);
	}
	
}
