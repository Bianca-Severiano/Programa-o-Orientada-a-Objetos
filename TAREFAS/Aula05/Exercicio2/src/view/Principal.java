package view;

import model.Conta;

public class Principal {
	public static void main(String[] args) {
		Conta c = new Conta();
		c.setAgencia(1);
		c.setCodigo(11);
		c.setLimite(100);
		c.setSaldo(100);
		
		c.deposito(100);
		System.out.println(c.getSaldo());
		
		try {
			c.sacar(400);
			System.out.println(c.getSaldo());
		} catch (ArithmeticException e) {
			System.err.println(e.getMessage());
		}
		
	}
}
