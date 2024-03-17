package view;

import model.ContaBancaria;

public class Principal {

	public static void main(String[] args) {
		ContaBancaria c1 = new ContaBancaria();
		c1.nome = "Conta1";
		c1.numeroConta = 1;
		c1.saldo = 1000.00;
		
		ContaBancaria c2 = new ContaBancaria();
		c2.nome = "Conta2";
		c2.numeroConta = 2;
		c2.saldo = 1000.00;
		
		
		System.out.println("Conta 1");
		c1.realizarDeposito(100);
		System.out.println(c1.saldo);
		c1.realizarSaque(50);
		System.out.println(c1.saldo);
		
		System.out.println("=================");
		
		System.out.println("Conta 2");
		c2.realizarDeposito(10);
		System.out.println(c2.saldo);
		c2.realizarSaque(500);
		System.out.println(c2.saldo);
		
		System.out.println("=================");

	}

}
