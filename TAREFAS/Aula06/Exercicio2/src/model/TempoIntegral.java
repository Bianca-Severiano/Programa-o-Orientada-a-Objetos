package model;

public class TempoIntegral extends Funcionario {
	private float bancoDeHoras;

	public TempoIntegral() {
		super();
	}

	public float getBancoDeHoras() {
		return bancoDeHoras;
	}

	public void setBancoDeHoras(float bancoDeHoras) {
		this.bancoDeHoras = bancoDeHoras;
	}
	
	public String toString() {
		return "TempoIntegral [bancoDeHoras=" + getBancoDeHoras() + ", ID=" + getIdentificador()
				+ ", Nome=" + getNome() + ", Salario=" + getSalario() + "]";
	}


}
