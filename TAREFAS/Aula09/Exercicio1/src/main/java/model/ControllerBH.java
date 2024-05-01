package model;

public class ControllerBH implements ICalculoImposto {
	private float area;
	private int quartos;

	public ControllerBH(float area, int quartos) {
		super();
		this.area = area;
		this.quartos = quartos;
	}

	@Override
	public float calculoImposto() {
		float imposto;
		imposto = (area * 7) + (quartos * 4);
		return imposto;
	}
}
