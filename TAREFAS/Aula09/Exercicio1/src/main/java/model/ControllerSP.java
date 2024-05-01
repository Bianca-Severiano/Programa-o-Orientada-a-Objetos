package model;

public class ControllerSP implements ICalculoImposto{
	
	private float area;
	private int qtdQuartos;
	
	
	public ControllerSP(float area, int qtdQuartos) {
		this.area = area;
		this.qtdQuartos = qtdQuartos;
	}
	
	@Override
	public float calculoImposto() {
		float imposto;
		imposto = (area * 10)+(qtdQuartos * 2);
		return imposto;
	}


}
