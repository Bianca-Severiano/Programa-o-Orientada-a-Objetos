package view;

import model.Funcionario;

public class Principal {

	public static void main(String[] args) {
		
		
		Funcionario f1 = new Funcionario();
		f1.setNome("Funcionario 1");
		f1.setCargo("Secretária Bilingue");
		f1.setSalario(5000.00);
		System.out.println(f1.getSalario());
		
		Funcionario f2 = new Funcionario();
		f2.setNome("Funcionario 2");
		f2.setCargo("Estagiario");
		f2.setSalario(800.00);
		System.out.println(f2.getSalario());
		
		System.out.println("Salários Pós cálculo Liquido");
		f1.getSalarioLiquido(100, 500);
		f2.getSalarioLiquido(1000, 500);
		System.out.println(f1.getSalario());
		System.out.println(f2.getSalario());
		
		
	}

}
