package model;

public class Conta {
	
	private int agencia;
	private int codigo;
	private int saldo;
	private float limite;
	
	public Conta() {
		super();
	}

	public void deposito(float valor){
		if (valor <= 0) {
			throw new ArithmeticException("Valor inválido para depósito");
		} else {
			saldo = (int) (saldo + valor);
		}
		
	}
	
	public void sacar(float valor) {
		float limiteSaque = saldo + limite;
		if (valor > limiteSaque) {
			throw new ArithmeticException("Saldo insuficiente para concluir ação, seu limite para saque é de R$ " + limiteSaque);
		} else {
			if (valor <= saldo) {
				saldo = (int) (saldo - valor);
			} else {
				limite = limite - (valor - saldo);
				saldo = 0;
			}
		}
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	
	
	
}
