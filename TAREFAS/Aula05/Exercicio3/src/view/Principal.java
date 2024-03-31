package view;

import controller.OperacaoController;

public class Principal {
	public static void main(String[] args) {
		OperacaoController op = new OperacaoController();
		
		try {
//			int resultado = op.operacaoValor(6);
//			int resultado = op.operacaoValor(3);
			int resultado = op.operacaoValor(-1);
			System.out.println(resultado);
		} catch (ArithmeticException e) {
			System.err.println(e.getMessage());
		} 
		

	}
}
