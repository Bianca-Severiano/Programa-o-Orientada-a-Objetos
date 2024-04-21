package model;

public class ContaPoupanca extends ContaBancaria {
private int diaRendimento;

	public ContaPoupanca() {
		this.diaRendimento = 1;
		setCliente("Cliente1");
		setNum_conta(1);
		setSaldo(500);
	}
	

	public String calcularNovoSaldo(float taxaRendimento) {
		float saldo = getSaldo();
		if (taxaRendimento < 0) {
			return "Taxa de rendimento inválida";
		} else {
			saldo = saldo + (saldo * taxaRendimento * diaRendimento);
			setSaldo(saldo);
			return "Seu saldo considerando é:" + saldo;
		}
	}


	public int getDiaRendimento() {
		return diaRendimento;
	}

	public void setDiaRendimento(int diaRendimento) {
		this.diaRendimento = diaRendimento;
	}

}
