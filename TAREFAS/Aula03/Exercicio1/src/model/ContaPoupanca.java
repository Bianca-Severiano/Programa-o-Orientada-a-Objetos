package model;

public class ContaPoupanca extends ContaBancaria {
	private int dia_de_rendimento;

	public ContaPoupanca() {
		super();
	}


	public int getDia_de_rendimento() {
		return dia_de_rendimento;
	}


	public void setDia_de_rendimento(int dia_de_rendimento) {
		this.dia_de_rendimento = dia_de_rendimento;
	}


	public float calcularNovoSaldo(float taxaRendimento) {
		float saldo = getSaldo();
		if (taxaRendimento < 0) {
			System.err.println("Taxa de rendimento inválida");
		} else {
			saldo = saldo + (saldo * taxaRendimento * dia_de_rendimento);
			setSaldo(saldo);
		}
		return getSaldo();
	}
	
}
