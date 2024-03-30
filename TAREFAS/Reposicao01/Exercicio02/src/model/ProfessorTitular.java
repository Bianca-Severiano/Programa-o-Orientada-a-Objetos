package model;

public class ProfessorTitular extends Professor {
	private int anosInstituicao;
	private double salarioBase;

	public ProfessorTitular() {
		super();
	}

	public int getAnosInstituicao() {
		return anosInstituicao;
	}

	public void setAnosInstituicao(int anosInstituicao) {
		if (anosInstituicao < 0) {
			System.out.println("Valor inválido para anosInstituição");
		} else {
			this.anosInstituicao = anosInstituicao;
		}
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	@Override
	public void calcSalario() {
		int reajuste = anosInstituicao/5;
		double salarioR = salarioBase + ((salarioBase * 0.05) * reajuste); 
		System.out.println("Salário do professor + reajuste por tempo de casa é: R$" + salarioR);
	}

}
