package controller;

public class OperacaoController {

	public int operacaoValor(int valor) {
		if (valor < 0) {
			throw new ArithmeticException("O parâmetro não pode ser negativo");
		} else {
			if (valor % 2 == 0) {
				return (int) Math.pow(valor, 2);
			} else {
				return (int) Math.pow(valor, 3);
			}
		}
	}
}
