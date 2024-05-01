package model;

public class ControllerPA implements ICalculoImposto  {
	
	private float area;
	private float haGaragem;
	
	
	
	public ControllerPA(float area, float haGaragem) {
		this.area = area;
		this.haGaragem = haGaragem;
	}

	@Override
	public float calculoImposto() {
		float imposto;
		if (haGaragem > 0) {
			imposto = (area * 7.5f) + (haGaragem * 2.5f) ;
		} else {
			imposto = area * 8;
		}
		return imposto;
	}
}
