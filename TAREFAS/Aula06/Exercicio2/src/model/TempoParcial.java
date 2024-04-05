package model;

public class TempoParcial extends Funcionario {
	private float horarioEntrada;
	private float horarioSaida;
	
	public TempoParcial() {
		super();
	}

	public float getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(float horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public float getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(float horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	
	public String toString() {
		return "TempoParcial [HorarioEntrada=" + getHorarioEntrada() + ", HorarioSaida=" + getHorarioSaida()
				+ ", ID=" + getIdentificador() + ", Nome=" + getNome() + ", Salario="
				+ getSalario() + "]";
	}
	
	
	
	
}
