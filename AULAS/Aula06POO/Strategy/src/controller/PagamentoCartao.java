package controller;

import javax.swing.JOptionPane;

public class PagamentoCartao implements IPagamentoStrategy {

	@Override
	public void fazerPagameento() {
			String CPF = JOptionPane.showInputDialog(null, "CPF Cliente");
		String nome = JOptionPane.showInputDialog(null, "Nome Cliente");
		String numCartao = JOptionPane.showInputDialog(null, "N° do Cartão");
		String cvvCartao = JOptionPane.showInputDialog(null, "CVV do Cartão");
		System.out.println(CPF+ " "+nome+ " "+ numCartao + " "+ cvvCartao + " ");
		
	}

}
