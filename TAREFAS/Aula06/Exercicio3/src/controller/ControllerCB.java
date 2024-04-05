package controller;

import javax.swing.JOptionPane;

public class ControllerCB implements IImposto {

	@Override
	public float CalculoImposto() {
		
		float area = Float.parseFloat(JOptionPane.showInputDialog(null, "Area do imovel"));
		float imposto = area * 5;
		int idadeImovel = Integer.parseInt(JOptionPane.showInputDialog(null, "Idade do Imovel:"));
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
