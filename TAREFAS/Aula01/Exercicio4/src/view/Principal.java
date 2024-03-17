package view;

import model.Produto;

public class Principal {
	public static void main (String args[]) {
		Produto p1 = new Produto ();
		Produto p2 = new Produto ();
		Produto p3 = new Produto ();
		
		System.out.println("PRODUTO 1");
		p1.setNome("Produto1");
		p1.setPreco(-5);
		p1.setQtdEstoque(10);
		System.out.println(p1.totalValorEstoque());
		System.out.println(p1.verificaProdutoDisponivel("Produto1"));
		
		System.out.println("PRODUTO 2");
		p2.setNome("Produto2");
		p2.setPreco(100);
		p2.setQtdEstoque(-10);
		System.out.println(p2.totalValorEstoque());
		System.out.println(p2.verificaProdutoDisponivel("Produto2"));
		
		System.out.println("PRODUTO 3");
		p3.setNome("Produto3");
		p3.setPreco(5);
		p3.setQtdEstoque(10);
		System.out.println(p3.totalValorEstoque());
		System.out.println(p3.verificaProdutoDisponivel("Produto3"));
		
		
	}
}
