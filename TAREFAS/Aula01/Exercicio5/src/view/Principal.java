package view;

import model.Pessoa;

public class Principal {
	public static void main (String args []) {
		Pessoa p1 = new Pessoa ();
		Pessoa p2 = new Pessoa ();
		Pessoa p3 = new Pessoa ();
		
		System.out.println("PESSOA 1");
		p1.setNome("Pessoa 1");
		p1.setProfissao("Analista jr");
		p1.setDataNascimento(31, 8, 2000);
		System.out.println(p1.getDataNascimento());
		
		System.out.println("PESSOA 2");
		p2.setNome("Pessoa 2");
		p2.setProfissao("Analista Pleno");
		p2.setDataNascimento(17, 3, 1874);
		System.out.println(p2.getDataNascimento());
		
		System.out.println("PESSOA 3");
		p3.setNome("Pessoa 3");
		p3.setProfissao("Analista sr");
		p3.setDataNascimento(25, 12, 1800);
		System.out.println(p3.getDataNascimento());
	}
}
