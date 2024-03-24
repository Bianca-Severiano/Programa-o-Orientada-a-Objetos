package model;

public class Supervisor extends Funcionario {

	public Supervisor() {
		super();
	}
	
	@Override
	public double calcSalario(int horas) {
		return 3000.00d + 1.5d * horas;
	}

	@Override
	public double calcBonus() {
		return 1000.00d;
	}
	
}
