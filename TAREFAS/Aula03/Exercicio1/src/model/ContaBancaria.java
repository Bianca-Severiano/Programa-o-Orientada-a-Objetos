package model;

public class ContaBancaria {
	private String cliente;
	private int num_conta;
	private float saldo;
	
	public ContaBancaria() {
		super();
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getNum_conta() {
		return num_conta;
	}

	public void setNum_conta(int num_conta) {
		this.num_conta = num_conta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		if (saldo < 0) {
			this.saldo = 0;
		} else {			
			this.saldo = saldo;
		}
	}
	
	
	public void sacar (float valor) {
		String Mensagem;
		float novoSaldo = saldo - valor;
		if (novoSaldo < 0) {
			Mensagem = "Saldo insuficiente";
		} else {
			saldo = novoSaldo;
			Mensagem = "Saque realizado";
		}
		
		System.out.println(Mensagem);
	}
	
	public void depositar (float valor) {
		String Mensagem;
		if (valor <= 0) {
			Mensagem = "Valor para depósito está incorreto";
		} else {
			saldo = saldo + valor;
			Mensagem = "Depósito realizado";
		}
		
		System.out.println(Mensagem);
	}

	@Override
	public String toString() {
		return "ContaBancaria [cliente=" + cliente + ", num_conta=" + num_conta + ", saldo=" + getSaldo() + "]";
	}
	
	
	
}
