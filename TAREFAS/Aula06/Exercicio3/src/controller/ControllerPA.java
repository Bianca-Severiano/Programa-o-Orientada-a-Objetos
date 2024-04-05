package controller;

import javax.swing.JOptionPane;

public class ControllerPA implements IImposto {

	@Override
	public float CalculoImposto() {
		float imposto;
		float area = Float.parseFloat(JOptionPane.showInputDialog(null, "Area do imovel"));
		float haGaragem = Float.parseFloat(JOptionPane.showInputDialog(null, "Area da garagem"));
		if (haGaragem > 0) {
			imposto = (area * 7.5f) + (haGaragem * 2.5f) ;
		} else {
			imposto = area * 8;
		}
		return imposto;
	}

}
