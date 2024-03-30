package controller;

public class OperacoesController {

	public OperacoesController() {
		super();
	}
	
	public int divisao(int vlr1, int vlr2) throws ArithmeticException {
		return vlr1/vlr2;
	}
	
	public int operaVetor(int[] vetor, int posicao) throws ArrayIndexOutOfBoundsException {
		return vetor[posicao] * 1000;
	}
	
	public String operaObjeto (Object obj) throws NullPointerException{
		if (obj == null) {
			throw new NullPointerException("Objeto nulo");
		} else {			
			return obj.toString();
		}
	}
	
}
