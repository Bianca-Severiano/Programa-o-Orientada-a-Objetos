package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ContaBancaria {
	private String cliente;
	private int num_conta;
	private float saldo;
	
	
	public ContaBancaria() {
		super();
	}

	public ContaBancaria( float saldo) {
		if (saldo < 0) {
			this.saldo = 0;
		} else {
			this.saldo = saldo;
		}
	}
	
	public String sacar(float valor) {
		if (valor > saldo) {
			return "Valor informado não pode ser sacado!";
		} else {
			saldo = saldo - valor;
			return "Saque realizado, saldo atual: " + saldo;
		}
	}
	
	public String depositar(float valor) {
		if (valor <= 0) {
			return "Valor informado não pode ser depositado!";
		} else {
			this.saldo = saldo + valor;
			return "Depósito realizado, saldo atual: " + saldo;
		}
	}
}
