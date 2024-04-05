package controller;

import javax.swing.JOptionPane;

public class ControllerBH implements IImposto {

	@Override
	public float CalculoImposto() {
		float imposto = 0;
		float area = Float.parseFloat(JOptionPane.showInputDialog(null, "Area do imovel"));
		int Quartos = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de Quartos:"));
		imposto = (area * 7) + (Quartos * 4);
		return imposto;
	}

}
