package model;

public class Vendedor extends Funcionario {
	
	public Vendedor() {
		super();
	}
	
	@Override
	public double calcSalario(int horas) {
		return 1400 + 1.1d * horas;
	}

	@Override
	public double calcBonus() {	
		return 500.00d;
	}
	
}
