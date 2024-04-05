package model;

public class Temporario extends Funcionario {
	
	private int diaFim;
	private int mesFim;
	private int anoFim;
	
	public Temporario() {
		super();
	}

	public int getDiaFim() {
		return diaFim;
	}

	public void setDiaFim(int diaFim) {
		this.diaFim = diaFim;
	}

	public int getMesFim() {
		return mesFim;
	}

	public void setMesFim(int mesFim) {
		this.mesFim = mesFim;
	}

	public int getAnoFim() {
		return anoFim;
	}

	public void setAnoFim(int anoFim) {
		this.anoFim = anoFim;
	}

	public String toString() {
		return "Temporario [DiaFim=" + getDiaFim() + ", MesFim=" + getMesFim() + ", AnoFim="
				+ getAnoFim() + ", ID=" + getIdentificador() + ", Nome=" + getNome()
				+ ", Salario=" + getSalario() + "]";
	}

	
	
	
	
	
	
	
}
