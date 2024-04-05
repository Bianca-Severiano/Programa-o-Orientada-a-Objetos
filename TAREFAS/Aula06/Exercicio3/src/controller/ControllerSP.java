package controller;

import javax.swing.JOptionPane;

public class ControllerSP implements IImposto{

	@Override
	public float CalculoImposto() {
		float imposto;
		float area = Float.parseFloat(JOptionPane.showInputDialog(null, "Area do imovel"));
		int qtdQuartos = Integer.parseInt(JOptionPane.showInputDialog(null, "Area do imovel"));
		imposto = (area * 10)+(qtdQuartos * 2);
		return imposto;
	}

}
