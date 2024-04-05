package controller;

import javax.swing.JOptionPane;

import model.Funcionario;
import model.Temporario;

public class ControllerTemporario implements IFuncionario {

	@Override
	public Funcionario contratacao() {
		Temporario f = new Temporario();
		f.setNome(JOptionPane.showInputDialog(null, "Nome"));
		f.setIdentificador(JOptionPane.showInputDialog(null, "ID"));
		f.setSalario(Float.parseFloat(JOptionPane.showInputDialog(null, "Salario")));
		f.setDiaFim(Integer.parseInt(JOptionPane.showInputDialog(null, "Dia do fim de contrato")));
		f.setMesFim(Integer.parseInt(JOptionPane.showInputDialog(null, "Mes do fim de contrato")));
		f.setAnoFim(Integer.parseInt(JOptionPane.showInputDialog(null, "Ano do fim de contrato")));
		return f;
	}

}
