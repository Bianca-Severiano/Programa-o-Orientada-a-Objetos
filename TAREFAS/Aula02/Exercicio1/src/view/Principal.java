package view;

import model.ItemPedido;
import model.Pedido;
import model.Produto;

public class Principal {

	public static void main(String[] args) {
		Produto p1 = new Produto();
		Produto p2 = new Produto();
		Produto p3 = new Produto();
		
		p1.setCodigo(0);
		p1.setDescricao("serve para a");
		p1.setValor(10);
		
		p2.setCodigo(2);
		p2.setDescricao("serve para b");
		p2.setValor(20);
		
		p3.setCodigo(3);
		p3.setDescricao("serve para c");
		p3.setValor(30);
		
		
		ItemPedido i1 = new ItemPedido();
		ItemPedido i2 = new ItemPedido();
		ItemPedido i3 = new ItemPedido();
		
		i1.setProduto(p1);
		i1.setQuantidade(3);
		
		i2.setProduto(p2);
		i2.setQuantidade(3);
		
		i3.setProduto(p3);
		i3.setQuantidade(3);
		
		Pedido p = new Pedido();
		p.setNumeroNota(12234);
		p.adicionarItem(i1);
		p.adicionarItem(i2);
		p.adicionarItem(i3);
		
		System.out.println(p.getValorTotal());

	}

}
