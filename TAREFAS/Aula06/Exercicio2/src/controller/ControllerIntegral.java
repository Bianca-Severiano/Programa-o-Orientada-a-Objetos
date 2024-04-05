package controller;

import javax.swing.JOptionPane;

import model.Funcionario;
import model.TempoIntegral;

public class ControllerIntegral implements IFuncionario {

	public ControllerIntegral() {
		super();
	}

	@Override
	public Funcionario contratacao() {
		TempoIntegral f = new TempoIntegral();
		f.setNome(JOptionPane.showInputDialog(null, "Nome"));
		f.setIdentificador(JOptionPane.showInputDialog(null, "ID"));
		f.setSalario(Float.parseFloat(JOptionPane.showInputDialog(null, "Salario")));
		f.setBancoDeHoras(Float.parseFloat(JOptionPane.showInputDialog(null, "Banco de Horaso")));
		return f;
	}
}
