package view;

import controller.OperacoesController;
import model.Pessoa;

public class Principal {
	public static void main(String[] args) {
		OperacoesController opCont = new OperacoesController();
		try {
			float divisao = opCont.divisao(100, 0);
			System.out.println(divisao);			
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.err.println("Não é possível dividir por zero");
		}
		
		int[] vetor = {9, 2, 5, 3};
		try {
			int operaVetor = opCont.operaVetor(vetor, 2);
			System.out.println(operaVetor);			
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.err.println("Posição inválida");
		} finally {
			int tamanho = vetor.length;
			int operaVetor = opCont.operaVetor(vetor, tamanho-1);
			System.out.println("Operação com a última posição: " + operaVetor);
		}
		
		
		Pessoa pessoa = null;
		try {
			String operaObjeto = opCont.operaObjeto(pessoa);
			System.out.println(operaObjeto);			
		} catch (NullPointerException e){
			System.err.println(e.getMessage());
		}
		
	}
}
