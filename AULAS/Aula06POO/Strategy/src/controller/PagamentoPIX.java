package controller;

import javax.swing.JOptionPane;

public class PagamentoPIX implements IPagamentoStrategy{
	@Override
	public void fazerPagameento() {
		 String chavePIX = JOptionPane.showInputDialog(null, "Informe a chave PIX");
		System.out.println("Pagamento por pix usando a chave " + chavePIX);
	
		
	}


}
