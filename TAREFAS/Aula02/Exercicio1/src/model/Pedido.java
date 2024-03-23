package model;

import bilbioteca.fila.dinamica.generica.model.Lista;

public class Pedido {
	
	private int numeroNota;
	private double valorTotal;
	Lista<ItemPedido> itens = new Lista<>();
		
	public Pedido() {
		super();
	}

	public int getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(int numeroNota) {
		this.numeroNota = numeroNota;
	}

	public double getValorTotal() {
		int tamanho = itens.size();
		for (int i = 0; i < tamanho; i++) {
			try {
				this.valorTotal = this.valorTotal + (itens.get(i).getQuantidade() * itens.get(i).getProduto().getValor());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return valorTotal;
	}

	public void adicionarItem(ItemPedido item) {
		itens.addFirst(item);
	}


}
