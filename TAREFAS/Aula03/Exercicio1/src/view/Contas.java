package view;

import model.ContaEspecial;
import model.ContaPoupanca;

public class Contas {

	public static void main(String[] args) {
		ContaPoupanca cp = new ContaPoupanca();
		cp.setCliente("Cliente Poupaça");
		cp.setDia_de_rendimento(1);
		cp.setNum_conta(00001);
		cp.setSaldo(1000);
		System.out.println(cp);
		//Saque
		cp.sacar(100);
		
		//Saque superior ao saldo
		cp.sacar(1000);
		
		//Deposito
		cp.depositar(2000);
		
		System.out.println(cp);
		
		//Saldo pos rendimento
		System.out.println("Saldo pós rendimento " + cp.calcularNovoSaldo(0.01f));
		System.out.println(cp);
		System.out.println("-----------------------------");
		
		
		ContaEspecial ce = new ContaEspecial();
		ce.setCliente("Cliente Especial");
		ce.setNum_conta(00002);
		ce.setSaldo(1000);
		ce.setLimite(500);
		System.out.println(ce);
		//Saque
		ce.sacar(100);
		
		//Saque superior ao saldo mas fora do limite
		ce.sacar(1800);
		
		//Saque superior ao saldo mas dentro do limite
		ce.sacar(1000);
		
		//Deposito
		ce.depositar(2000);
		System.out.println(ce);

	}

}
