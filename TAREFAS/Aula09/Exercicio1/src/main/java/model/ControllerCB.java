package model;

public class ControllerCB implements ICalculoImposto   {
	
	float area;
	float idadeImovel;
	
	

	public ControllerCB(float area, float idadeImovel) {
		this.area = area;
		this.idadeImovel = idadeImovel;
	}


	@Override
	public float calculoImposto() {
		float imposto = area * 5;
		if (idadeImovel >= 50) {
			imposto = imposto + (idadeImovel * 3);
		} else {
			if (idadeImovel <= 20) {
				imposto = imposto + (idadeImovel * 2);
			} else {
				imposto = imposto + (idadeImovel * 2.5f);
			}
		}
		return imposto;
	}
}
