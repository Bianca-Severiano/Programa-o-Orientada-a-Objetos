package view;

import model.Eletronico;
import model.Livro;
import model.Produto;

public class Principal {

	public static void main(String[] args) {
		Produto p = new Produto();
		p.setNome("Smartphone");
		p.setPreco(1500.00d);
		System.out.println(p);
		System.out.println(p.ehCaro());
		System.out.println("---------------------------------");
		
		Livro l = new Livro();
		l.setNome("Sistemas Operacionais Modernos");
		l.setAutor("A. Tanebaum");
		l.setPreco(300.00d);
		l.setQtdPaginas(650);
		System.out.println(l);
		System.out.println(l.ehCaro());
		System.out.println(l.ehGrande());
		System.out.println("---------------------------------");
		
		Eletronico e = new Eletronico();
		e.setNome("Televisão 55 pol.");
		e.setPreco(4000.00d);
		e.setVoltagem(127);
		System.out.println(e);
		System.out.println(e.ehCaro());
		e.setPreco(1200.00d);
		System.out.println(e.ehCaro());
		//System.out.println(e.valorComDesconto(e.getPreco()));
		//System.out.println(e.valorComDesconto(12));
		System.out.println("---------------------------------");
		
		Produto e2 = new Eletronico();
		e2.setNome("Radio");
		System.out.println(e2);
		System.out.println(e2.ehCaro());
		
		
		

	}

}
