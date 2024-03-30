package view;

import controller.IPagamentoStrategy;
import controller.PagamentoCartao;
import controller.PagamentoDinheiro;
import controller.PagamentoPIX;

public class Principal {
	public static void main(String[] args) {
		IPagamentoStrategy pagamento = new PagamentoPIX();
		pagamento.fazerPagameento();
		
		pagamento = new PagamentoCartao();
		pagamento.fazerPagameento();
		
		pagamento = new PagamentoDinheiro();
		pagamento.fazerPagameento();
	}
}
