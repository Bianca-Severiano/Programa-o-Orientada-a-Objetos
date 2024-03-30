package model;

public class ContaEspecial extends ContaBancaria {
	private float limite;

	
	public ContaEspecial() {
		super();
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public void sacar(float valor) {
		String Mensagem;
		float saldo = getSaldo();
		float novoSaldo = saldo - valor;
		
		if (novoSaldo < 0) {
			if ((novoSaldo * (-1) <= limite) ) {
				Mensagem = "Saque realizado utilizando o limite de conta especial";
				limite = limite - (valor - saldo);
				saldo = 0;
			} else {
				Mensagem = "Saldo insuficiente";
			}
		} else {
			saldo = novoSaldo;
			Mensagem = "Saque realizado utilizando saldo de conta especial";
		}
		setSaldo(saldo);
		System.out.println(Mensagem);
	}


}
