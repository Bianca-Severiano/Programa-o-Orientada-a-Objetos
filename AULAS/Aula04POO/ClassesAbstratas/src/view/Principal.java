package view;

import model.Supervisor;
import model.Vendedor;

public class Principal {

	public static void main(String[] args) {
		Vendedor v = new Vendedor();
		v.setCPF("12345678911");
		v.setNome("Vendedor1");
		
		System.out.println(v.calcSalario(40) + v.calcBonus());
		
		Supervisor s = new Supervisor();
		s.setCPF("22345678911");
		s.setNome("Supervisor1");
		
		System.out.println(s.calcSalario(40) + s.calcBonus());

	}

}
