package controller;

import javax.swing.JOptionPane;

public class PagamentoDinheiro implements IPagamentoStrategy {


	@Override
	public void fazerPagameento() {
		String troco = JOptionPane.showInputDialog(null, "Troco para quanto");
		System.out.println("Cliente precisa de troco para " + troco );
		
		
	}

}
