package view;

import model.ProfessorHorista;
import model.ProfessorTitular;

public class Principal {

	public static void main(String[] args) {
		ProfessorTitular pt = new ProfessorTitular();
		pt.setNome("Professor A");
		pt.setMatricula("abc1");
		pt.setIdade(50);
		pt.setAnosInstituicao(25);
		pt.setSalarioBase(1000);
		pt.calcSalario();
		
		
		ProfessorHorista ph = new ProfessorHorista();
		ph.setNome("Professor B");
		ph.setMatricula("abc2");
		ph.setIdade(50);
		ph.setHorasAula(100);
		ph.setValorHoraAula(20);
		ph.calcSalario();
		
		
	}

}
