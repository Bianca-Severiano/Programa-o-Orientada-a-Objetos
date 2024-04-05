package controller;

import javax.swing.JOptionPane;

import model.Funcionario;
import model.TempoParcial;

public class ControllerTempoParcial implements IFuncionario {

	@Override
	public Funcionario contratacao() {
		TempoParcial f = new TempoParcial();
		f.setNome(JOptionPane.showInputDialog(null, "Nome"));
		f.setIdentificador(JOptionPane.showInputDialog(null, "ID"));
		f.setSalario(Float.parseFloat(JOptionPane.showInputDialog(null, "Salario")));
		f.setHorarioEntrada(Float.parseFloat(JOptionPane.showInputDialog(null, "Horário de Entrada")));
		f.setHorarioSaida(Float.parseFloat(JOptionPane.showInputDialog(null, "Horário de Saída")));
		return f;
	}

}
